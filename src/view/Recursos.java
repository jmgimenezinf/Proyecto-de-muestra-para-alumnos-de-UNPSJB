package view;

import javax.swing.ImageIcon;

public class Recursos {
	private static final String BASE_PATH = "/images/";
	
	private static final String NOMBRE_NAVE_ARRIBA = "naveUp.gif";
	private static final String NOMBRE_NAVE_ABAJO = "naveDown.gif";
	private static final String NOMBRE_NAVE_IZQUIERDA = "naveLeft.gif";
	private static final String NOMBRE_NAVE_DERECHA = "naveRight.gif";
	
	private static ImageIcon obtenerImagen(String nombreImagen) {
		String path = BASE_PATH + nombreImagen;
		return new ImageIcon(Recursos.class.getResource(path));
	}
	
	public static final ImageIcon IMG_NAVE_ARRIBA = obtenerImagen(NOMBRE_NAVE_ARRIBA);
	public static final ImageIcon IMG_NAVE_ABAJO = obtenerImagen(NOMBRE_NAVE_ABAJO);
	public static final ImageIcon IMG_NAVE_IZQUIERDA = obtenerImagen(NOMBRE_NAVE_IZQUIERDA);
	public static final ImageIcon IMG_NAVE_DERECHA = obtenerImagen(NOMBRE_NAVE_DERECHA);
}