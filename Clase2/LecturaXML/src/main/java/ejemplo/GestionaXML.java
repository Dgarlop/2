package ejemplo;

import java.io.IOException;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class GestionaXML {
	private static final String RUTA_RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws SAXException, IOException {

		// 1. Crear el analizador DOM
		UtilesDomXML utiles = new UtilesDomXML();

		// 2. Leer el fichero XML
		Document doc = utiles.getDocumentFromXML("libro.xml");
		Element raiz = doc.getDocumentElement();

		List<Libro> libros = utiles.leerVariosLibros(raiz);
		System.out.println(libros);

	}
}
  