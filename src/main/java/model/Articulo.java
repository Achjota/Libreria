package model;

public class Articulo {
	private String nombre;
	private String tipoArticulo;
	private double peso;
	private double precio;

	public Articulo(String s, String datum, String nombre) {
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre() {
		this.nombre=nombre;
	}

	public String getTipoArticulo() {
		return this.tipoArticulo;
	}

	public void setTipoArticulo() {
		this.tipoArticulo=tipoArticulo;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso() {
		this.peso=peso;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio() {
		this.precio=precio;
	}

	public void add(Articulo articulo) {
	}
}