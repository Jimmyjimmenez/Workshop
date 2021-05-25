package Presentacion.Componente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Presentacion.Vista;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.FactoriaVistas.FactoriaVistas;

public class VistaComponente extends JFrame implements Vista {
	
	Vista vistaAlta;
	Vista vistaBaja;
	Vista vistaMostrar;
	Vista vistaMostrarXProveedor;
	Vista vistaModificar;
	Vista vistaListar;

	public VistaComponente() {
		super("Men� Componente");
		JPanel panel = new JPanel();
		JButton alta = new JButton("Alta");
		JButton baja = new JButton("Baja");
		JButton modificar = new JButton("Modificar");
		JButton mostrar = new JButton("Mostrar");
		JButton mostarXProveedor = new JButton("Mostrar por Proveedor");
		JButton listar = new JButton("Listar");
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBackground(Color.RED);
		panel.add(alta);
		panel.add(baja);
		panel.add(modificar);
		panel.add(mostrar);
		panel.add(mostarXProveedor);
		panel.add(listar);
		panel.add(cancelar);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vistaAlta = FactoriaVistas.obtenerInstancia().crearVista(Eventos.ALTA_COMPONENTE);
			}
		});

		baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vistaBaja = FactoriaVistas.obtenerInstancia().crearVista(Eventos.BAJA_COMPONENTE);
			}
		});
		
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vistaModificar = FactoriaVistas.obtenerInstancia().crearVista(Eventos.MODIFICAR_COMPONENTE);
			}
		});
		
		mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vistaMostrar = FactoriaVistas.obtenerInstancia().crearVista(Eventos.MOSTRAR_COMPONENTE);
			}
		});
		
		mostarXProveedor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vistaMostrarXProveedor = FactoriaVistas.obtenerInstancia().crearVista(Eventos.MOSTRAR_COMPONENTE_PROVEEDOR);
			}
		});
		
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vistaListar = FactoriaVistas.obtenerInstancia().crearVista(Eventos.LISTAR_COMPONENTE);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FactoriaVistas.obtenerInstancia().crearVista(Eventos.TALLER);
			}
		});
	}


	@Override
	public void actualizar(int evento, Object datos) {
		if (vistaAlta != null)
		{
			vistaAlta.actualizar(evento, datos);
			vistaAlta = null;
		}
		else if (vistaBaja != null)
		{
			vistaBaja.actualizar(evento, datos);
			vistaBaja = null;
		}
		else if (vistaMostrarXProveedor != null)
		{
			vistaMostrarXProveedor.actualizar(evento, datos);
			vistaMostrarXProveedor = null;
		}
		else if (vistaMostrar != null)
		{
			vistaMostrar.actualizar(evento, datos);
			vistaMostrar = null;
		}	
		else if (vistaModificar != null)
		{
			vistaModificar.actualizar(evento, datos);
			vistaModificar = null;
		}
		else if (vistaListar != null) 
		{
			vistaListar.actualizar(evento, datos);
			vistaListar = null;
		}	
	}

}
