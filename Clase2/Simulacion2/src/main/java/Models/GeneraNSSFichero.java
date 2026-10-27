package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GeneraNSSFichero {

	public static void main(String[] args) throws IOException {
		GeneraNSSFichero genera = new GeneraNSSFichero();
		String ruta = args[0];
		System.out.println("Ha pasado los args");
		String palabra = genera.buscador(ruta);
		System.out.println(palabra);
	}
	
	public String buscador(String ruta) throws FileNotFoundException {
		Scanner scan = null;
		File archivo = new File(ruta);
		String nss = null;
		
		FileReader fichero;
		try {
			fichero = new FileReader(archivo);
			scan = new Scanner(fichero);
			while (scan.hasNext()) {
                scan.nextLine();
                while(scan.hasNextLine()) {
                	if(scan.nextLine().startsWith("AN")) {
                    	nss = scan.nextLine();
                    	//System.out.println(nss);
                    }
                }
            }
		} finally {
            if (scan != null) {
                scan.close();
            }
        }
		return nss;
		
	}
	

}
