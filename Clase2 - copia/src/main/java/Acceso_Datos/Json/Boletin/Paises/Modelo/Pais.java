package Acceso_Datos.Json.Boletin.Paises.Modelo;

public class Pais {
	private String nombre;
	private String continente; 
	private String población; 
	private String idioma;
	private String moneda;
	
	
	
	public Pais(String nombre, String continente) {
		super();
		this.nombre = nombre;
		this.continente = continente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String getPoblación() {
		return población;
	}
	public void setPoblación(String población) {
		this.población = población;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", continente=" + continente + ", población=" + población + ", idioma="
				+ idioma + ", moneda=" + moneda + "]";
	}
}
