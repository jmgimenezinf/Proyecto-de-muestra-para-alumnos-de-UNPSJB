package model;

import java.util.ArrayList;

public class NaveModel implements Sujeto {
	private Orientacion orientacion = Orientacion.Arriba;
	private final Size size;
	private Posicion posicion;
	private int velocidad;
	private ArrayList<Observador> observadores = new ArrayList<Observador>();
	
	public NaveModel(){
		size = new Size(184, 250);
		posicion = new Posicion(100, 100);
		this.setVelocidad(5);
	}
	
	public void mover(Orientacion direccion) {
		orientacion = direccion;
		
		switch(direccion) {
		case Arriba:    posicion.add(0, -velocidad); break;
		case Abajo:     posicion.add(0,  velocidad); break;
		case Izquierda: posicion.add(-velocidad, 0); break;
		case Derecha:   posicion.add( velocidad, 0); break;
		}
		
		notificar();
	}
	
	public Orientacion getOrientacion() {
		return orientacion;
	}
	
	public void pilotoAutomatico(){
		for (int i = 1; i < 20; i++) {
			mover(Orientacion.Abajo);
		}
		for (int j = 1; j < 20; j++) {
			mover(Orientacion.Derecha);
		}
		for (int k = 1; k < 20; k++) {
			mover(Orientacion.Arriba);
		}
		for (int l = 1; l < 20; l++) {
			mover(Orientacion.Izquierda);
		}
	}
	
	public void setVelocidad(int velocidad){
		this.velocidad = velocidad;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public Size getSize() {
		return size;
	}
	
	public int getVelocidad(){
		return this.velocidad;
	}
	
	private ArrayList<Observador> getObservadores(){
		return this.observadores;
	}
	
	@Override
	public void agregar(Observador observador) {
		this.getObservadores().add(observador);
	}

	@Override
	public void quitar(Observador observador) {
		this.getObservadores().remove(observador);
	}


	@Override
	public void notificar() {
		for (Observador observador : this.getObservadores()) {
		    observador.actualizar();
		}
		
	}
}
