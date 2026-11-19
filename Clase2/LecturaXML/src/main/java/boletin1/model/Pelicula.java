package boletin1.model;

public class Pelicula {
	private String titulo;
	private int ano;
	private String director;
	public Pelicula() {
		super();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", ano=" + ano + ", director=" + director + "]";
	}

	
}
