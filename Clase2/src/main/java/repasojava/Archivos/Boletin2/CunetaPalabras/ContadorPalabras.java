package repasojava.Archivos.Boletin2.CunetaPalabras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContadorPalabras {
	public static void main(String[] args) {
		
	}
	public List leerArchivo(String rutaYNombre) throws FileNotFoundException {
		List<String> lista = new ArrayList<String>() {};
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			//Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { //Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return lista;
	}

}
