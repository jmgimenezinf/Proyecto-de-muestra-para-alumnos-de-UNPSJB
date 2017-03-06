package view;

import java.awt.Container;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import model.Posicion;
import model.Size;

public class ControlVelocidad {
	private final JSpinner spinner = new JSpinner();
	
	public ControlVelocidad(Posicion posicion, Size tamaño, int value) {
		spinner.setBounds(
			posicion.getX(),
			posicion.getY(),
			tamaño.getWidth(),
			tamaño.getHeight()
		);
		
		spinner.setValue(value);
	}
	
	public int getValue() {
		SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
		return model.getNumber().intValue();
	}
	
	public void addChangeListener(ChangeListener listener) {
		spinner.addChangeListener(listener);
	}
	
	public void setContainer(Container container) {
		container.add(spinner);
	}
}
