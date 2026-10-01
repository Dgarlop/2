package Archivos.Boletin;

import java.io.File;
import java.util.Scanner;
import Archivos.Boletin.RutaNoValidaException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Ejercicio1 {
	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce la ruta: ");
		String ruta = scanner.nextLine();
		File directorio = new File (ruta);
		
		try {
			if(!directorio.exists()) {
			throw new RutaNoValidaException("No existe el directorio");}
			if (!directorio.isDirectory()) {
				throw new RutaNoValidaException("No es un directorio");
				/*if(directorio.isFile()) {
					throw new RutaNoValidaException("No es un directorio");
				}*/
			} 
			else {
				throw new RutaNoValidaException("Es un directorio");
			}
		}
		catch (RutaNoValidaException  e) {
			// TODO Auto-generated catch block
			logger.error("Error al crear fichero:" + e.getMessage());
		}
	}

}
