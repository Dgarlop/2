package Archivos.Boletin;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Archivos.ejercicio1;

public class Ejercicio2 {
	private static final Logger logger = LogManager.getLogger(Ejercicio2.class);

	public void mostrarDirectorio(String ruta) throws RutaNoValidaException {
		File directorio = new File(ruta);
		if (directorio.exists()){
			if(directorio.isDirectory()) {
				for(File f : directorio.listFiles())
		        {
					if(f.isDirectory()) {
						logger.debug("Carpeta / Directorio : " + f.getName());
						mostrarDirectorio(f.getAbsolutePath());
					}
					else {
						logger.debug(ruta);
						logger.debug(f.getName());		
					}
		        }
			}
			else {
				logger.debug(ruta);
				logger.debug(directorio.getName());
			}
		}
		else {
			throw new RutaNoValidaException("La ruta no exite");
		}
		
		

	}
	public static void main(String[] args) {
		Ejercicio2 e = new Ejercicio2();
		String rutaDirectorio = "C:\\Users\\alumno\\Desktop\\2\\App_Web";
		try {
			e.mostrarDirectorio(rutaDirectorio);
		} catch (RutaNoValidaException e1) {
			// TODO Auto-generated catch block
			logger.error("Error al acceder al fichero:" + e1.getMessage());
		}
	}
}
