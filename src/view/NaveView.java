package view;

import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.NaveModel;
import model.Observador;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;
import java.awt.event.KeyListener;


public class NaveView implements Observador {
	public JFrame ventana;
	private JLabel nave;
	private NaveModel naveModel;
	private JSpinner ctrVelocidad;
	
	/**
	 * Create the application.
	 * @throws MalformedURLException 
	 */
	public NaveView(NaveModel naveModel) throws MalformedURLException {
		this.naveModel = naveModel;
		initialize();
	}
	
	private void crearVentana() {
		ventana = new JFrame();
		ventana.getContentPane().setBackground(Color.BLACK); // cambio el color del fondo 
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
	}
	
	private int getValueSpinner() {
		SpinnerNumberModel model = (SpinnerNumberModel) ctrVelocidad.getModel();
		return model.getNumber().intValue();
	}
	
	private void addSpinner() {
		ctrVelocidad = new JSpinner();
		ctrVelocidad.setBounds(10, 10, 153, 32);
		ctrVelocidad.setValue(5);
		
		ctrVelocidad.addChangeListener(e -> naveModel.setVelocidad(getValueSpinner()));
		
		ventana.getContentPane().add(ctrVelocidad);
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
		nave.setBounds(33, 29, this.naveModel.getWidthNave(),this.naveModel.getHeightNave());
		ventana.getContentPane().add(nave);
		nave.requestFocus();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws MalformedURLException 
	 */
	private void initialize() throws MalformedURLException {
		crearVentana();
		addSpinner();
		addLabel();
		addNave();
	}
	
	public void setVisible(boolean visible){
		ventana.setVisible(visible);
	}
	
	private void setIcon(ImageIcon icon) {
		nave.setIcon(icon);
	}
	
	//metodos
	public void naveArriba(){
		setIcon(Recursos.IMG_NAVE_ARRIBA);
	}
	
	public void naveAbajo() {
		setIcon(Recursos.IMG_NAVE_ABAJO);
	}
	
	public void naveDerecha() {
		setIcon(Recursos.IMG_NAVE_DERECHA);
	}
	
	public void naveIzquierda() {
		setIcon(Recursos.IMG_NAVE_IZQUIERDA);
	}
	
	private void actualizarPosicionNave(int posX, int posY) {
		nave.setBounds(posX, posY, naveModel.getWidthNave(), naveModel.getHeightNave());
	}
	
	public void addKeyListener(KeyListener keyListener) {
		ventana.setFocusable(true);
		ventana.addKeyListener(keyListener);
	}

	//metodos de interfaces
	public void actualizar() {
		actualizarPosicionNave(naveModel.getXVentana(), naveModel.getYVentana());
	}
}
