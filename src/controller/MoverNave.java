package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import model.NaveModel;
import model.Orientacion;

public class MoverNave implements KeyListener {
	public final NaveModel nave;
	public final Map<Integer, Orientacion> direcciones;
	
	public MoverNave(NaveModel nave) {
		this.nave = nave;
		direcciones = new HashMap<Integer, Orientacion>();
		direcciones.put(KeyEvent.VK_UP, Orientacion.Arriba);
		direcciones.put(KeyEvent.VK_DOWN, Orientacion.Abajo);
		direcciones.put(KeyEvent.VK_LEFT, Orientacion.Izquierda);
		direcciones.put(KeyEvent.VK_RIGHT, Orientacion.Derecha);
	}
	
	private boolean validKey(int key) {
		return direcciones.containsKey(key);
	}
	
	private void moverNave(int key) {
		nave.mover(direcciones.get(key));
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if(validKey(key)) {
			moverNave(key);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}
