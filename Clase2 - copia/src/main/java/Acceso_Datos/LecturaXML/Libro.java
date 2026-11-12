package Acceso_Datos.LecturaXML;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Libro {
	private String id;
	private String categoria;
	private String titulo;
	private String autor;
	
	
	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	private static final String RUTA_RESOURCES = "src/main/resources/";
	
	public static void main(String[] args) throws SAXException, IOException {

            // 1. Crear el analizador DOM
            DocumentBuilderFactory factory =   DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
			try {
				
				builder = factory.newDocumentBuilder();
			
            // 2. Leer el fichero XML
            Document doc = builder.parse( new File(RUTA_RESOURCES + "libro.xml"));

            // 3. Obtener el elemento titulo → El Quijote
            Element titulo = (Element) doc.getElementsByTagName("titulo").item(0);
            //logger.debug(titulo.getTextContent());
            System.out.println(titulo.getTextContent());
            
            Libro libro = new Libro(titulo.getTextContent());
            
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        

	}
	
	

}
