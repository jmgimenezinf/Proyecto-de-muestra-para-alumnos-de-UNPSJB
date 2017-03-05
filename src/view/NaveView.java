package view;

import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.NaveModel;
import model.Observador;
import java.awt.Color;


public class NaveView implements Observador {

	public JFrame ventana;
	private JLabel nave;
	private NaveModel naveModel;
	
	public void setVisible(boolean visible){
		this.ventana.setVisible(visible);
	}
	/**
	 * Launch the application.
	 */

	
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
		this.setNave(new JLabel(new ImageIcon(NaveView.class.getResource("/images/nave.gif"))));
		this.getNave().setBounds(33, 29, this.naveModel.getWidthNave(),this.naveModel.getHeightNave());

		ventana.getContentPane().add(this.getNave());
		
	
	}
	
	public JLabel getNave(){
		return this.nave ;
	} 
	private void setNave(JLabel nave){
		this.nave=nave;
	}
	@Override
	public void actualizar() {
		this.getNave().setBounds(this.naveModel.getXVentana(),
				this.naveModel.getYVentana(),this.naveModel.getWidthNave(),this.naveModel.getHeightNave());
		
	}
	
	

}
