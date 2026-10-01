package Archivos;

import java.io.IOException;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ejercicio1 {
	//Creamos fichero y directorios
	private static final Logger logger = LogManager.getLogger(ejercicio1.class);
	
	public static void main(String[] args) {
		String rutaDirecotorio = "C:\\Users\\alumno\\Desktop\\2\\Acceso_Datos"; //Ruta absoluta, la recomendacion es que sea relativa
		File directorio = new File(rutaDirecotorio);
		File fichero = new File(directorio, "fichero.txt");
		try {
			boolean creado = fichero.createNewFile(); 
			// borrar fichero : creado = fichero.delete();
			//comprobacion de que esta creado: if (fichero.exists()) { System.out.println("El archivo existe."); }	
			/*Listar archivos:
			 * File f = new File(nombreDir); //tiene que ser un directorio
				String[] archivos = f.list(); 
				File[] archivos = f.listFiles(); 
			 * */

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Error al crear fichero:" + e.getMessage());
		}
	}
}


