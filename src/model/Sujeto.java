package model;

public interface Sujeto {
	public void agregar (Observador observador);
	public void quitar (Observador observador);
	public void notificar();
		
}
