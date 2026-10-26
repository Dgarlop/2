package psp.Boletin2.Ejercicio2.Repositorios;

import java.io.IOException;
import java.lang.classfile.attribute.InnerClassesAttribute;

public class LanzadorAnalizadorTemperatura {
	public static void main(String[] args) throws IOException, InterruptedException {
		String rutaClasses = "target/classes";
		String pack = "psp.Boletin2.Ejercicio2.Models.AnalizadorTemperaturas";
		String ruta = "src/main/resources/Temperaturas";
		int[] umbrales = {10, 20, 25, 30, 35};	
		for(int umbral:umbrales) {
			ejecuta(Integer.toString(umbral), ruta, rutaClasses, pack);
		}
		
	}
	public void compila () {}
	public static void ejecuta (String umbral, String ruta ,String rutaClasses, String pack) throws IOException, InterruptedException {
		String[] comandos = {"java", "-cp",rutaClasses,pack , umbral,ruta};
		ProcessBuilder pb = new ProcessBuilder(comandos);
		pb.inheritIO();
		Process p = pb.start();
		p.waitFor();
		
	}

}
