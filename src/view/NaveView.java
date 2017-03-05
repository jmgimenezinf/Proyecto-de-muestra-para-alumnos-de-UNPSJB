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
	
	//metodos
	public void naveArriba(){this.getNave().setIcon(new ImageIcon(NaveView.class.getResource("/images/naveUp.gif")));}
	public void naveAbajo(){this.getNave().setIcon(new ImageIcon(NaveView.class.getResource("/images/naveDown.gif")));	}
	public void naveDerecha(){	this.getNave().setIcon(new ImageIcon(NaveView.class.getResource("/images/naveRight.gif")));}
	public void naveIzquierda(){this.getNave().setIcon(new ImageIcon(NaveView.class.getResource("/images/naveLeft.gif")));	}

	//metodos de interfaces
	public void actualizar() {
		this.getNave().setBounds(this.naveModel.getXVentana(),
				this.naveModel.getYVentana(),this.naveModel.getWidthNave(),
				this.naveModel.getHeightNave());
	}
}
