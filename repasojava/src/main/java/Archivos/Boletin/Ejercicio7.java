package Archivos.Boletin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio7 {
	private static final Logger logger = LogManager.getLogger(Ejercicio7.class);
	public List<File> buscar(String ruta, String nombre) throws RutaNoValidaException {
		List encontrado = new ArrayList<File>();
		File directorio = new File(ruta);
		if (directorio.exists()){
			if(directorio.isDirectory()) {
				for(File f : directorio.listFiles())
		        {
					if(f.isDirectory()) {
						buscar(f.getAbsolutePath(), nombre);
					}
					else {
						if(f.getName().contains(nombre)) {
							encontrado.add(f.getName());	
						}
						
					}
		        }
			}
			else {
				if(directorio.getName().contains(nombre)) {
					encontrado.add(directorio.getName());
				}
				
			}
		}
		else {
			throw new RutaNoValidaException("La ruta no exite");
		}
		return encontrado;
	}
}
