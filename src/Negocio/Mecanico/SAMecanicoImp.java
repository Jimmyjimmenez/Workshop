package Negocio.Mecanico;

import java.util.ArrayList;
import java.util.Collection;
import Integracion.Especialidad.DAOEspecialidad;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.Mecanico.DAOMecanico;
import Integracion.Reparacion.DAOReparacion;
import Negocio.DataCorrect;
import Negocio.Especialidad.TEspecialidad;
import Negocio.Reparacion.TTrabaja;

public class SAMecanicoImp implements SAMecanico {

	@Override
	public int alta(TMecanico tMecanico) {
		if (tMecanico == null)
			return 0;

		if (!DataCorrect.dniCorrecto(tMecanico.getDNI()))
			return 0;

		if (!DataCorrect.numeroMayorCero(tMecanico.getSueldo()))
			return 0;

		if (!DataCorrect.stringSoloDigitosCorrecto(tMecanico.getCuenta(), 24))
			return 0;

		if (!DataCorrect.stringCorrecto(tMecanico.getNombre()))
			return 0;

		if (!DataCorrect.stringSoloDigitosCorrecto(tMecanico.getTelefono(), 9))
			return 0;

		if(tMecanico.getIdEspecialidad() <= 0)
			return 0;
		
		int idEspecialidad = idEspecialidadExiste(tMecanico.getIdEspecialidad());
		if (idEspecialidad < 0)
			return idEspecialidad;

		DAOMecanico dao = FactoriaIntegracion.obtenerInstancia().crearMecanico();
		TMecanico leido = dao.leerPorNif(tMecanico.getDNI());

		int resultado = -1;

		if (leido == null)
			return dao.alta(tMecanico);
		
		if(leido.getId() == -4)
			return -4;
		
		if (!leido.isActivo())
			return dao.reactivar(leido.getId());

		return resultado;
	}

	@Override
	public int baja(int id) {
		if (!DataCorrect.numeroMayorCero(id))
			return 0;

		DAOMecanico dao = FactoriaIntegracion.obtenerInstancia().crearMecanico();
		TMecanico leido = dao.mostrar(id);

		int resultado;

		if (leido == null)
			return -1;
		else if(leido.getId() == -4)
			return -4;
		else if(!leido.isActivo())
			return -1;
		
		int trabajando = trabajandoEnReparacion(leido.getId());
		if (trabajando < 0)
			return trabajando;
		else
			resultado = dao.baja(id);

		return resultado;
	}

	@Override
	public int modificar(TMecanico tMecanico) {
		if (tMecanico == null)
			return 0;

		if (!DataCorrect.numeroMayorCero(tMecanico.getId()))
			return 0;

		if (tMecanico.getDNI().length() != 0 && !DataCorrect.dniCorrecto(tMecanico.getDNI()))
			return 0;
		
		if (tMecanico.getNombre().length() != 0 && !DataCorrect.stringCorrecto(tMecanico.getNombre()))
			return 0;
		
		if (tMecanico.getSueldo() < 0)
			return 0;

		if (tMecanico.getCuenta().length() != 0 && !DataCorrect.stringSoloDigitosCorrecto(tMecanico.getCuenta(), 24))
			return 0;

		if (tMecanico.getTelefono().length() != 0 && !DataCorrect.stringSoloDigitosCorrecto(tMecanico.getTelefono(), 9))
			return 0;

		if(tMecanico.getIdEspecialidad() < 0)
			return 0;
		
		int idEspecialidad = idEspecialidadExiste(tMecanico.getIdEspecialidad());
		
		if(idEspecialidad < 0)
			return idEspecialidad;

		DAOMecanico dao = FactoriaIntegracion.obtenerInstancia().crearMecanico();
		TMecanico leido = dao.mostrar(tMecanico.getId());
		int resultado;

		TMecanico aux = dao.leerPorNif(tMecanico.getDNI());
		
		if (leido == null)
			resultado = -1;
		else if(leido.getId() == -4)
			resultado = -4;
		else if(!leido.isActivo())
			resultado = -1;
		else if (aux != null && aux.getId() == -4)
			resultado = -4;
		else if(aux != null && aux.getId() != tMecanico.getId())
			resultado = -2;
		else{
			tMecanico.setDNI(tMecanico.getDNI().equals("") ? leido.getDNI() : tMecanico.getDNI());
			tMecanico.setNombre(tMecanico.getNombre().equals("") ? leido.getNombre() : tMecanico.getNombre());
			tMecanico.setCuenta(tMecanico.getCuenta().equals("") ? leido.getCuenta() : tMecanico.getCuenta());
			tMecanico.setTelefono(tMecanico.getTelefono().equals("") ? leido.getTelefono() : tMecanico.getTelefono());
			tMecanico.setSueldo(tMecanico.getSueldo() == 0 ? leido.getSueldo() : tMecanico.getSueldo());
			tMecanico.setIdEspecialidad(tMecanico.getIdEspecialidad() == 0 ? leido.getIdEspecialidad() : tMecanico.getIdEspecialidad());
			
			resultado = dao.modificar(tMecanico);			
		}

		return resultado;
	}

	@Override
	public TMecanico mostrar(int id) {
		if (!DataCorrect.numeroMayorCero(id))
			return new TMecanico(0);

		DAOMecanico dao = FactoriaIntegracion.obtenerInstancia().crearMecanico();
		TMecanico leido = dao.mostrar(id);
		
		if (leido == null)
			return new TMecanico(-1);
		
		if(leido.getId() == -4)
			return new TMecanico(-4);
		
		if(!leido.isActivo())
			return new TMecanico(-1);

		return leido;
	}

	@Override
	public Collection<TMecanico> listar() {
		DAOMecanico dao = FactoriaIntegracion.obtenerInstancia().crearMecanico();
		Collection<TMecanico> resultado = dao.listar();

		return resultado;
	}

	@Override
	public Collection<TMecanico> mostrarMecanicosEspecialidad(int idEspecialidad) {
		Collection<TMecanico> resultado = new ArrayList<TMecanico>();
		
		if (!DataCorrect.numeroMayorCero(idEspecialidad)) {
			resultado.add(new TMecanico(0));

			return resultado;
		}

		idEspecialidad = idEspecialidadExiste(idEspecialidad);
		if (idEspecialidad < 0) {
			resultado.add(new TMecanico(idEspecialidad));

			return resultado;
		}

		DAOMecanico dao = FactoriaIntegracion.obtenerInstancia().crearMecanico();

		resultado = dao.mostrarMecanicosEspecialidad(idEspecialidad);

		return resultado;
	}

	private int idEspecialidadExiste(int idEspecialidad) {
		DAOEspecialidad daoEspecialidad = FactoriaIntegracion.obtenerInstancia().crearEspecialidad();
		TEspecialidad tEsp = daoEspecialidad.mostrar(idEspecialidad);
		
		if (tEsp == null)
			return -3;
		
		if(tEsp.getId() == -4)
			return -4;
		
		if(!tEsp.isActivo())
			return -3;

		return tEsp.getId();
	}
	
	private int trabajandoEnReparacion(int idMecanico){
		DAOReparacion daoReparacion = FactoriaIntegracion.obtenerInstancia().crearReparacion();
		TTrabaja trabaja = daoReparacion.existeMecanico(idMecanico);
		
		if(trabaja == null)
			return idMecanico;
		else if(trabaja.getIdReparacion() == -4)
			return -4;
		else
			return -2;
	}
}
