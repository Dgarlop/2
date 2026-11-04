package Models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneraNSSFichero {

	public static void main(String[] args) throws IOException {
		GeneraNSSFichero genera = new GeneraNSSFichero();
		String ruta = args[0];
		genera.buscador(ruta);
	}

	public void buscador(String ruta) throws IOException {
		Scanner scan = null;
		File archivo = new File(ruta);
		FileReader fichero;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("NSSs.txt"));
			fichero = new FileReader(archivo);
			scan = new Scanner(fichero);
			try {

				while (scan.hasNextLine()) {
					String linea = scan.nextLine();

					if (linea.startsWith("AN")) {
						bw.write(linea);
						bw.newLine();
					}
				}

			} finally {
				bw.close();

			}
		} finally {
			if (scan != null) {
				scan.close();
			}
		}

	}

}
