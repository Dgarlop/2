/*package Archivos.Boletin2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Archivos.Boletin2.Ejercicio1;

public class Ejercicio1 {
	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String[] informacionProceso = {"C:\\Users\\alumno\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"};
		try {
		ProcessBuilder runner = new ProcessBuilder();
		runner.start("chomre.exe");
		Process proceso;
		proceso = rt.exec(informacionProceso);
		}
		catch(IOException e){
			e.printStackTrace();
		}


	}

}*/
