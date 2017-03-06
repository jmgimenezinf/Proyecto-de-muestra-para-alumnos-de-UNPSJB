package view;

import java.net.MalformedURLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;

import model.NaveModel;
import model.Observador;
import model.Orientacion;
import model.Posicion;
import model.Size;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyListener;


public class NaveView implements Observador {
	private JFrame ventana;
	private ControlVelocidad control;
	private JLabel nave;
	private NaveModel naveModel;
	
	/**
	 * Create the application.
	 * @throws MalformedURLException 
	 */
	public NaveView(NaveModel naveModel) throws MalformedURLException {
		this.naveModel = naveModel;
		naveModel.agregar(this);
		initialize();
	}
	
	private void crearVentana() {
		ventana = new JFrame();
		ventana.setMinimumSize(new Dimension(300,300));
		ventana.getContentPane().setBackground(Color.BLACK); // cambio el color del fondo 
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
	}
	
	private void addControlVelocidad() {
		Size size = new Size(153, 32);
		Posicion pos = new Posicion(10, 10);
		control = new ControlVelocidad(pos, size, 5);
		control.setContainer(ventana.getContentPane());
	}
	
	private void addLabel() {
		JLabel lblVelocidad = new JLabel("VELOCIDAD");
		lblVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblVelocidad.setForeground(Color.RED);
		lblVelocidad.setBounds(186, 14, 169, 15);
		ventana.getContentPane().add(lblVelocidad);
	}
	
	private void addNave() {
		nave = new JLabel(Recursos.IMG_NAVE_ARRIBA);
		Size size = naveModel.getSize();
		nave.setBounds(33, 29, size.getWidth(),size.getHeight());
		ventana.getContentPane().add(nave);
		nave.requestFocus();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws MalformedURLException 
	 */
	private void initialize() throws MalformedURLException {
		crearVentana();
		addControlVelocidad();
		addLabel();
		addNave();
		ventana.setVisible(true);
	}
	
	private void actualizarOrientacion(Orientacion orientacion) {
		switch(orientacion) {
		case Arriba: nave.setIcon(Recursos.IMG_NAVE_ARRIBA); break;
		case Abajo: nave.setIcon(Recursos.IMG_NAVE_ABAJO); break;
		case Derecha: nave.setIcon(Recursos.IMG_NAVE_DERECHA); break;
		case Izquierda: nave.setIcon(Recursos.IMG_NAVE_IZQUIERDA); break;
		default: throw new IndexOutOfBoundsException();
		}
	}
	
	private void actualizarPosicionNave(Posicion posicion) {
		nave.setBounds(
			posicion.getX(),
			posicion.getY(),
			naveModel.getSize().getWidth(),
			naveModel.getSize().getHeight()
		);
	}
	
	public void addKeyListener(KeyListener keyListener) {
		ventana.setFocusable(true);
		ventana.addKeyListener(keyListener);
	}
	
	public void addChangeListener(ChangeListener listener) {
		control.addChangeListener(listener);
	}
	
	public int getValueControlVelocidad() {
		return control.getValue();
	}
	
	public void focusAVentana() {
		ventana.requestFocus();
	}

	public void actualizar() {
		actualizarPosicionNave(naveModel.getPosicion());
		actualizarOrientacion(naveModel.getOrientacion());
	}
}
