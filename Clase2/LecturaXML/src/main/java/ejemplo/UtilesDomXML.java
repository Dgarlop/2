package ejemplo;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UtilesDomXML {
	private static final String RUTA_RESOURCES = "src/main/resources/";

	public Document getDocumentFromXML(String nombrefichero) {
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();

			doc = builder.parse(new File(RUTA_RESOURCES + "libro.xml"));
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;

	}

	public Libro fromElement2Libro(Element raiz) {

		Element tituloElement = (Element) raiz.getElementsByTagName("titulo").item(0);
		Element autorElement = (Element) raiz.getElementsByTagName("autor").item(0);

		String titulo = tituloElement.getTextContent();
		String autor = autorElement.getTextContent();
		String id = raiz.getAttribute("id");
		String categoria = raiz.getAttribute("categoria");

		Libro libro = new Libro(titulo);
		libro.setAutor(autor);
		libro.setId(id);
		libro.setCategoria(categoria);
		System.out.println(libro);
		return libro;
	}
	
	public List<Libro> leerVariosLibros(Element raiz) {
		List<Libro> lLb = new ArrayList<>();
		NodeList nodosLibros = raiz.getElementsByTagName("libro");
		for(int i = 0; i<nodosLibros.getLength(); i ++) {
			Libro l = this.fromElement2Libro((Element) nodosLibros.item(i));
			lLb.add(l);
		}
		return lLb;
	}

}
