package boletin1.repositorio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import boletin1.model.Pelicula;
import ejemplo.Libro;

public class XMLDomPeliculas {
	private static final String RUTA_RESOURCES = "src/main/resources/";
	public Document getDocumentFromXML(String nombrefichero) {
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();

			doc = builder.parse(new File(RUTA_RESOURCES + "peliculas.xml"));
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
	
	public Pelicula fromElement2Pelicula(Element raiz){
		Element tituloElement = (Element) raiz.getElementsByTagName("Titulo").item(0);
		Element fechaElement = (Element) raiz.getElementsByTagName("Fecha").item(0);
		Element directorElement = (Element) raiz.getElementsByTagName("Director").item(0);

		String titulo = tituloElement.getTextContent();
		String anoText = fechaElement.getTextContent();
		String director = directorElement.getTextContent();
		
		int ano = Integer.parseInt(anoText);

		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(titulo);
		pelicula.setAno(ano);
		pelicula.setDirector(director);
		System.out.println(pelicula);
		return pelicula;
	}
	
	public List<Pelicula> leerVariasPeliculas(Element raiz) {
		List<Pelicula> Listpeli= new ArrayList<>();
		NodeList nodosPeli = raiz.getElementsByTagName("Pelicula");
		for(int i = 0; i<nodosPeli.getLength(); i ++) {
			Pelicula p = this.fromElement2Pelicula((Element) nodosPeli.item(i));
			Listpeli.add(p);
		}
		return Listpeli;
	}
}
