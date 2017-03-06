package controller;

import java.awt.EventQueue;
import java.net.MalformedURLException;

import model.NaveModel;
import view.NaveView;

public class NaveController {
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
	
	private void actualizarVelocidad(NaveModel naveModel, NaveView naveView) {
		int velocidad = naveView.getValueControlVelocidad();
		naveModel.setVelocidad(velocidad);
		naveView.focusAVentana();
	}
	
	public void initialize() throws MalformedURLException{
		NaveModel naveModel = new NaveModel();
		NaveView naveView = new NaveView(naveModel);
		naveView.addKeyListener(new MoverNave(naveModel));
		naveView.addChangeListener((event) -> actualizarVelocidad(naveModel, naveView));
	}
}
