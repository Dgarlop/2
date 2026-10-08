package Archivos.Boletin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio7Controller {
	private static final Logger logger = LogManager.getLogger(Ejercicio7Controller.class);
	public static void main(String[] args) {
		Ejercicio7 ej = new Ejercicio7();
		try {
			logger.debug(ej.buscar("C:\\Users\\alumno\\Desktop\\2\\repasojava\\src\\main\\java\\Archivos\\Boletin", "E"));
		} catch (RutaNoValidaException e) {
			e.printStackTrace();
		}
	}

}
