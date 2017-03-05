package controller;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;

import model.NaveModel;
import view.NaveView;

public class NaveController implements KeyListener {

	private NaveView unaNaveView;
	private NaveModel unaNaveModel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				NaveController controladorNave = new NaveController();
				controladorNave.initialize();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void initialize() throws MalformedURLException{
		this.setUnaNaveModel(new NaveModel());
		this.setUnaNaveView(new NaveView(this.getUnaNaveModel()));
		this.getUnaNaveModel().agregar(this.getUnaNaveView());
		getUnaNaveView().setVisible(true);
		getUnaNaveView().ventana.addKeyListener(this);
		
	}
	
	public void keyPressed(KeyEvent e) {

		if( e.getKeyCode() == e.VK_DOWN) {
			this.getUnaNaveModel().abajo();
		}
		if(e.getKeyCode()== e.VK_UP){
			this.getUnaNaveModel().arriba();
		}
		if(e.getKeyCode() == e.VK_LEFT){
			this.getUnaNaveModel().izquierda();
		}
		if(e.getKeyCode() == e.VK_RIGHT){
			this.getUnaNaveModel().derecha();
		}
	}

	private void setUnaNaveView(NaveView naveView){
		this.unaNaveView = naveView;
	}	
	private NaveView getUnaNaveView(){
		return this.unaNaveView;
	}
	
	private void setUnaNaveModel(NaveModel naveModel){
		this.unaNaveModel = naveModel;
	}	
	private NaveModel getUnaNaveModel(){
		return this.unaNaveModel;
	}


	//Metodos de interfaces
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
