package Presentacion.FactoriaVistas;

import Presentacion.Vista;
import Presentacion.Cliente.*;
import Presentacion.Componente.VistaAltaComponente;
import Presentacion.Componente.VistaBajaComponente;
import Presentacion.Componente.VistaComponente;
import Presentacion.Componente.VistaListarComponente;
import Presentacion.Componente.VistaModificarComponente;
import Presentacion.Componente.VistaMostrarComponente;
import Presentacion.Componente.VistaMostrarComponentesProveedor;
import Presentacion.Controlador.Eventos;
import Presentacion.Especialidad.*;
import Presentacion.Mecanico.*;
import Presentacion.Proveedor.*;
import Presentacion.Reparacion.VistaAltaReparacion;
import Presentacion.Reparacion.VistaAnyadirComponente;
import Presentacion.Reparacion.VistaAnyadirMecanico;
import Presentacion.Reparacion.VistaBajaReparacion;
import Presentacion.Reparacion.VistaBorrarComponenteReparacion;
import Presentacion.Reparacion.VistaBorrarMecanicoReparacion;
import Presentacion.Reparacion.VistaListarReparacion;
import Presentacion.Reparacion.VistaModificarComponenteReparacion;
import Presentacion.Reparacion.VistaModificarMecanicoReparacion;
import Presentacion.Reparacion.VistaModificarReparacion;
import Presentacion.Reparacion.VistaMostrarReparacion;
import Presentacion.Reparacion.VistaMostrarVehiculoReparacion;
import Presentacion.Reparacion.VistaReparacion;
import Presentacion.Taller.VistaTaller;
import Presentacion.Vehiculo.VistaAltaVehiculo;
import Presentacion.Vehiculo.VistaBajaVehiculo;
import Presentacion.Vehiculo.VistaListarVehiculo;
import Presentacion.Vehiculo.VistaModificarVehiculo;
import Presentacion.Vehiculo.VistaMostrarVehiculo;
import Presentacion.Vehiculo.VistaMostrarVehiculosCliente;
import Presentacion.Vehiculo.VistaVehiculo;

public class FactoriaVistasImp extends FactoriaVistas {

	private Vista vistaTaller = null;
	private Vista vistaEspecialidad = null;
	private Vista vistaMecanico = null;
	private Vista vistaProveedor = null;
	private Vista vistaComponente = null;
	private Vista vistaCliente = null;
	private Vista vistaVehiculo = null;
	private Vista vistaReparacion = null;
	@Override
	public Vista crearVista(int tipo) {
		Vista resultado = null;
		switch(tipo)
		{
		case Eventos.TALLER: 
			if(vistaTaller == null)
				vistaTaller = new VistaTaller();
			else
			{
				((VistaTaller) vistaTaller).setVisible(true);
			}
			resultado = vistaTaller;
			break;
		case Eventos.ESPECIALIDAD:
			if(vistaEspecialidad == null)
				vistaEspecialidad = new VistaEspecialidad();
			else
			{
				((VistaEspecialidad) vistaEspecialidad).setVisible(true);
			}
			resultado = vistaEspecialidad;
			break;
		case Eventos.ALTA_ESPECIALIDAD:
			resultado = new VistaAltaEspecialidad();
			break;
		case Eventos.BAJA_ESPECIALIDAD:
			resultado = new VistaBajaEspecialidad();
			break;
		case Eventos.MODIFICAR_ESPECIALIDAD:
			resultado = new VistaModificarEspecialidad();
			break;
		case Eventos.MOSTRAR_ESPECIALIDAD:
			resultado =  new VistaMostrarEspecialidad();
			break;
		case Eventos.LISTAR_ESPECIALIDAD:
			resultado = new VistaListarEspecialidad();;
			break;
		case Eventos.PROVEEDOR:
			if(vistaProveedor == null)
				vistaProveedor = new VistaProveedor();
			else
			{
				((VistaProveedor) vistaProveedor).setVisible(true);
			}
			resultado = vistaProveedor;
			break;
		case Eventos.ALTA_PROVEEDOR:
			resultado = new VistaAltaProveedor();
			break;
		case Eventos.BAJA_PROVEEDOR:
			resultado = new VistaBajaProveedor();
			break;
		case Eventos.MODIFICAR_PROVEEDOR:
			resultado = new VistaModificarProveedor();
			break;
		case Eventos.MOSTRAR_PROVEEDOR:
			resultado = new VistaMostrarProveedor();
			break;
		case Eventos.LISTAR_PROVEEDOR:
			resultado = new VistaListarProveedor();
			break;
		case Eventos.CLIENTE:
			if(vistaCliente == null)
				vistaCliente = new VistaCliente();
			else
			{
				((VistaCliente) vistaCliente).setVisible(true);
			}
			resultado = vistaCliente;
			break;
		case Eventos.ALTA_CLIENTE:
			resultado = new VistaAltaCliente();
			break;
		case Eventos.BAJA_CLIENTE:
			resultado = new VistaBajaCliente();
			break;
		case Eventos.MOSTRAR_CLIENTE:
			resultado = new VistaMostrarCliente();
			break;
		case Eventos.LISTAR_CLIENTE:
			resultado = new VistaListarCliente();
			break;
		case Eventos.MODIFICAR_CLIENTE:
			resultado = new VistaModificarCliente();
			break;
		case Eventos.MECANICO:
			if(vistaMecanico == null)
				vistaMecanico = new VistaMecanico();
			else
			{
				((VistaMecanico) vistaMecanico).setVisible(true);
			}
			resultado = vistaMecanico;
			break;
		case Eventos.ALTA_MECANICO:
			resultado = new VistaAltaMecanico();
			break;
		case Eventos.BAJA_MECANICO:
			resultado = new VistaBajaMecanico();
			break;
		case Eventos.MODIFICAR_MECANICO:
			resultado = new VistaModificarMecanico();
			break;
		case Eventos.MOSTRAR_MECANICO:
			resultado = new VistaMostrarMecanico();
			break;
		case Eventos.LISTAR_MECANICO:
			resultado = new VistaListarMecanico();
			break;
		case Eventos.MOSTRAR_MECANICO_ESPECIALIDAD:
			resultado = new VistaMostrarMecanicosEspecialidad();
			break;
		case Eventos.COMPONENTE:
			if(vistaComponente == null)
				vistaComponente = new VistaComponente();
			else
			{
				((VistaComponente) vistaComponente).setVisible(true);
			}
			resultado = vistaComponente;
			break;
		case Eventos.ALTA_COMPONENTE:
			resultado = new VistaAltaComponente();
			break;
		case Eventos.BAJA_COMPONENTE:
			resultado = new VistaBajaComponente();
			break;
		case Eventos.MOSTRAR_COMPONENTE:
			resultado = new VistaMostrarComponente();
			break;
		case Eventos.MODIFICAR_COMPONENTE:
			resultado = new VistaModificarComponente();
			break;
		case Eventos.MOSTRAR_COMPONENTE_PROVEEDOR:
			resultado = new VistaMostrarComponentesProveedor();
			break;
		case Eventos.LISTAR_COMPONENTE:
			resultado = new VistaListarComponente();
			break;
		case Eventos.VEHICULO:
			if(vistaVehiculo == null)
				vistaVehiculo = new VistaVehiculo();
			else
			{
				((VistaVehiculo) vistaVehiculo).setVisible(true);
			}
			resultado = vistaVehiculo;
			break;
		case Eventos.ALTA_VEHICULO:
			resultado = new VistaAltaVehiculo();
			break;
		case Eventos.BAJA_VEHICULO:
			resultado = new VistaBajaVehiculo();
			break;
		case Eventos.MOSTRAR_VEHICULO:
			resultado = new VistaMostrarVehiculo();
			break;
		case Eventos.MODIFICAR_VEHICULO:
			resultado = new VistaModificarVehiculo();
			break;
		case Eventos.MOSTRAR_VEHICULO_CLIENTE:
			resultado = new VistaMostrarVehiculosCliente();
			break;
		case Eventos.LISTAR_VEHICULO:
			resultado = new VistaListarVehiculo();
			break;
		case Eventos.REPARACION:
			if(vistaReparacion == null)
				vistaReparacion = new VistaReparacion();
			else
			{
				((VistaReparacion) vistaReparacion).setVisible(true);
			}
			resultado = vistaReparacion;
			break;
		case Eventos.ALTA_REPARACION:
			resultado = new VistaAltaReparacion();
			break;
		case Eventos.BAJA_REPARACION:
			resultado = new VistaBajaReparacion();
			break;
		case Eventos.MOSTRAR_REPARACION:
			resultado = new VistaMostrarReparacion();
			break;
		case Eventos.MODIFICAR_REPARACION:
			resultado = new VistaModificarReparacion();
			break;
		case Eventos.LISTAR_REPARACION://Faltan
			resultado = new VistaListarReparacion();
			break;
		case Eventos.ANYADIR_COMPONENTE_REPARACION:
			resultado = new VistaAnyadirComponente();
			break;
		case Eventos.ANYADIR_MECANICO_REPARACION:
			resultado = new VistaAnyadirMecanico();
			break;
		case Eventos.BORRAR_COMPONENTE_REPARACION:
			resultado = new VistaBorrarComponenteReparacion();
			break;
		case Eventos.BORRAR_MECANICO_REPARACION:
			resultado = new VistaBorrarMecanicoReparacion();
			break;
		case Eventos.MODIFICAR_COMPONENTE_REPARACION:
			resultado = new VistaModificarComponenteReparacion();
			break;
		case Eventos.MODIFICAR_MECANICO_REPARACION:
			resultado = new VistaModificarMecanicoReparacion();
			break;
		case Eventos.MOSTRAR_REPARACION_VEHICULO:
			resultado = new VistaMostrarVehiculoReparacion();
			break;
		}
		
		return resultado;
	}	

}