package view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyListener;

public class VentanaJuego {
	private final JFrame ventana = new JFrame();
	
	public VentanaJuego() {
		maximizar();
		cambiarColorFondo(Color.BLACK);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
	}
	
	private void cambiarColorFondo(Color color) {
		ventana.getContentPane().setBackground(color);
	}
	
	private void maximizar() {
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void requestFocus() {
		ventana.requestFocus();
	}
	
	public Container getContentPane() {
		return ventana.getContentPane();
	}

	public void setVisible(boolean b) {
		ventana.setVisible(b);
	}
	
	public void addKeyListener(KeyListener listener) {
		ventana.setFocusable(true);
		ventana.addKeyListener(listener);
	}
}
