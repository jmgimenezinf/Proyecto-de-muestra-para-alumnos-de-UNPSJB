package view;

import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.NaveModel;
import model.Observador;
import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.Font;


public class NaveView implements Observador {

	public JFrame ventana;
	private JLabel nave;
	private NaveModel naveModel;
	private JSpinner ctrVelocidad;
	
	/**
	 * Create the application.
	 * @throws MalformedURLException 
	 */
	public NaveView( NaveModel naveModel ) throws MalformedURLException {
		this.naveModel= naveModel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws MalformedURLException 
	 */
	private void initialize() throws MalformedURLException {
		ventana = new JFrame();
		ventana.getContentPane().setBackground(Color.BLACK); // cambio el color del fondo 
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
		
		ctrVelocidad = new JSpinner();
		ctrVelocidad.setBounds(10, 10, 153, 32);
		ventana.getContentPane().add(ctrVelocidad);
		
		JLabel lblVelocidad = new JLabel("VELOCIDAD");
		lblVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblVelocidad.setForeground(Color.RED);
		lblVelocidad.setBounds(186, 14, 169, 15);
		ventana.getContentPane().add(lblVelocidad);
		
		this.setNave(new JLabel(new ImageIcon(NaveView.class.getResource("/images/naveUp.gif"))));
		this.getNave().setBounds(33, 29, this.naveModel.getWidthNave(),this.naveModel.getHeightNave());
		ventana.getContentPane().add(this.getNave());
	}
	
	//getter and setters 
	public JLabel getNave(){
		return this.nave ;
	} 
	private void setNave(JLabel nave){
		this.nave=nave;
	}
	public void setVisible(boolean visible){
		this.ventana.setVisible(visible);
	}
	
	private void setIcon(ImageIcon icon) {
		this.nave.setIcon(icon);
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

	//metodos de interfaces
	public void actualizar() {
		this.getNave().setBounds(this.naveModel.getXVentana(),
				this.naveModel.getYVentana(),this.naveModel.getWidthNave(),
				this.naveModel.getHeightNave());
	}
}
