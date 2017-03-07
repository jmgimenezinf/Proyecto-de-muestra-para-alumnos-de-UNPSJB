package controller;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import model.NaveModel;
import view.NaveView;

public class NaveController implements KeyListener {
	private NaveView unaNaveView;
	private NaveModel unaNaveModel;
	private static Logger logger = Logger.getLogger("NaveController");
	
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
		unaNaveModel = new NaveModel();
		unaNaveView = new NaveView(unaNaveModel);
		unaNaveView.setVisible(true);
		unaNaveView.addKeyListener(this);
	}
	
	private boolean validKey(int key) {
		List<Integer> validKeys = Arrays.asList(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		logger.info(String.format("Teclas Válidas: %s", validKeys));
		return validKeys.contains(key);
	}
	
	private void moverNave(int key) {
		switch(key) {
		case KeyEvent.VK_DOWN: unaNaveModel.abajo(); break;
		case KeyEvent.VK_UP: unaNaveModel.arriba(); break;
		case KeyEvent.VK_RIGHT: unaNaveModel.derecha(); break;
		case KeyEvent.VK_LEFT: unaNaveModel.izquierda(); break;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		logger.info(String.format("Tecla Presionada: %d", key));
		
		if(validKey(key)) {
			logger.info("¡Tecla Válida!");
			moverNave(key);
		}
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
