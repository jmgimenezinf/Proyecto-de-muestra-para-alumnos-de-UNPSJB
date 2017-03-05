package model;

import java.util.ArrayList;

public class NaveModel implements Sujeto {

	private int posXVentana; //posicion X de la nave dentro de la ventana
	private int posYVentana;//posicion Y de la nave dentro de la ventana
	private int widthNave;
	private int heightNave;
	private ArrayList<Observador> observadores = new ArrayList<Observador>();
	//constructor
	public NaveModel(){
		this.setXVentana(100);
		this.setYVentana(100);
		this.setHeightNave(250);
		this.setWidthNave(184);
	}
	
	
	// metodos 
	
	public void arriba(){
		this.setYVentana(this.getYVentana()-5);
		this.notificar();
	}
	
	public void abajo(){
		this.setYVentana(this.getYVentana()+5);
		this.notificar();
		
	}
	public void izquierda(){
		this.setXVentana(this.getXVentana()-5);
		this.notificar();
	}
	public void derecha(){
		this.setXVentana(this.getXVentana()+5);
		this.notificar();
	}
	
	public void pilotoAutomatico(){
	
		for (int i = 1; i < 20; i++) {
			this.abajo();
		}
		for (int j = 1; j < 20; j++) {
			this.derecha();
		}
		for (int k = 1; k < 20; k++) {
			this.arriba();
		}
		for (int l = 1; l < 20; l++) {
			this.izquierda();
		}

	}
	
	
	// getters and setters
	public void setXVentana(int posXVentana){
		this.posXVentana= posXVentana;
	}
	public void setYVentana(int posYVentana){
		this.posYVentana= posYVentana;
	}
	
	public void setWidthNave(int widthNave){
		this.widthNave= widthNave;
	}
	public void setHeightNave(int heigthNave){
		this.heightNave=heigthNave;
	}
	
	
	public int getYVentana(){
		return this.posYVentana;		
	}
	
	public int getXVentana(){
		return this.posXVentana;
	}
	public int getWidthNave(){
		return this.widthNave;
	}
	public int getHeightNave(){
		return this.heightNave;
	}
	private ArrayList<Observador> getObservadores(){
		return this.observadores;
	}

	
	//metodos de interfaces

	@Override
	public void agregar(Observador observador) {
		// TODO Auto-generated method stub
		this.getObservadores().add(observador);
		
	}



	@Override
	public void quitar(Observador observador) {
		// TODO Auto-generated method stub
		this.getObservadores().remove(observador);
		
	}


	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		for (Observador observador : this.getObservadores()) {
		    observador.actualizar();
		}
		
	}
	
}
