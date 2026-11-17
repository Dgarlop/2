package boletin2.ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Contador implements Runnable {

	@Override
	public void run() {
		try {
			recorrer();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void recorrer () throws FileNotFoundException {
		String r = "src/main/resources";
		File carpeta = new File(r);
		if(carpeta.isDirectory()) {
			System.out.println("Estoy en resources");
			File[] archivos = carpeta.listFiles(); 
			for(File f : archivos) {
				System.out.println("Archivo: " + f.getName() + " caracteres: " + f.length());
			}
		}
	}

}
