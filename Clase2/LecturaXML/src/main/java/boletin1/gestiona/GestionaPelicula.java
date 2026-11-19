package boletin1.gestiona;

import java.io.IOException;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import boletin1.model.Pelicula;
import boletin1.repositorio.XMLDomPeliculas;

public class GestionaPelicula {
	private static final String RUTA_RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws SAXException, IOException {

		// 1. Crear el analizador DOM
		XMLDomPeliculas utiles = new XMLDomPeliculas();

		// 2. Leer el fichero XML
		Document doc = utiles.getDocumentFromXML("peliculas.xml");
		Element raiz = doc.getDocumentElement();

		List<Pelicula> peliculas = utiles.leerVariasPeliculas(raiz);
		System.out.println(peliculas);

	}
}
  