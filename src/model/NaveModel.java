package model;

import java.util.ArrayList;

public class NaveModel implements Sujeto {
	private int posXVentana; //posicion X de la nave dentro de la ventana
	private int posYVentana;//posicion Y de la nave dentro de la ventana
	private Orientacion orientacion = Orientacion.Arriba;
	private final int widthNave;
	private final int heightNave;
	private int velocidad;
	private ArrayList<Observador> observadores = new ArrayList<Observador>();
	
	//constructor
	public NaveModel(){
		widthNave = 184;
		heightNave = 250;
		this.setXVentana(100);
		this.setYVentana(100);
		this.setVelocidad(5);
	}
	
	
	// metodos 
	
	public void arriba(){
		this.setYVentana(this.getYVentana() - this.velocidad);
		this.orientacion = Orientacion.Arriba;
		this.notificar();
	}
	
	public void abajo(){
		this.setYVentana(this.getYVentana() + this.velocidad);
		this.orientacion = Orientacion.Abajo;
		this.notificar();
		
	}
	public void izquierda(){
		this.setXVentana(this.getXVentana() - this.velocidad);
		this.orientacion = Orientacion.Izquierda;
		this.notificar();
	}
	public void derecha(){
		this.setXVentana(this.getXVentana() + this.velocidad);
		this.orientacion = Orientacion.Derecha;
		this.notificar();
	}

	public Orientacion getOrientacion() {
		return this.orientacion;
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
		this.posXVentana = posXVentana;
	}
	public void setVelocidad(int velocidad){
		this.velocidad = velocidad;
	}
	public void setYVentana(int posYVentana){
		this.posYVentana = posYVentana;
	}
	
	public int getYVentana(){
		return this.posYVentana;		
	}
	
	public int getXVentana(){
		return this.posXVentana;
	}
	public int getWidthNave(){
		return widthNave;
	}
	public int getHeightNave(){
		return heightNave;
	}
	public int getVelocidad(){
		return this.velocidad;
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
