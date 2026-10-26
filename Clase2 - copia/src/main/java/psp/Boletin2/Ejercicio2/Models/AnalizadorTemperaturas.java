
package psp.Boletin2.Ejercicio2.Models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AnalizadorTemperaturas {

	public static void main(String[] args) throws IOException {
	    AnalizadorTemperaturas analizador = new AnalizadorTemperaturas();
	    

	    try {
	    	int valor = Integer.parseInt(args[0]);
	    	String ruta = args[1];
	        int resultado = analizador.analizador(valor, ruta);
	        System.out.println("Dias con temperatura superior a " + valor+ ": " + resultado);
	        try (BufferedWriter bf = new BufferedWriter(new FileWriter(valor + ".txt"))){
	        	bf.write(Integer.toString(resultado));
	        }
			
	    } catch (FileNotFoundException e) {
	        System.out.println("No se encuentra el fichero.");
	    }
	}

    public int analizador(int valor, String ruta) throws FileNotFoundException {
        int dias = 0;
        Scanner scan = null;
         File archivo = new File(ruta);

        try {
            FileReader fichero = new FileReader(archivo);
            scan = new Scanner(fichero);

            while (scan.hasNext()) {
                scan.next();

                while (scan.hasNextInt()) {
                    if (scan.nextInt() > valor) {
                        dias = dias + 1;
                    }
                }
            }
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        return dias;
    }
}
