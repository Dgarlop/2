package Archivos.Boletin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio8{
	private static final Logger logger = LogManager.getLogger(Ejercicio8.class);
	public List<File> buscar(String ruta) throws RutaNoValidaException{
		List encontrado = new ArrayList<File>();
		Arrays.sort(encontrado, new ComparatorEjercicio8());
		File directorio = new File(ruta);
		if(directorio.exists()) {
			for(File f: directorio.listFiles()) {
				
			}
		}
		else {
			throw new RutaNoValidaException("La ruta no exite");
		}
		return encontrado;
		
	}

}
