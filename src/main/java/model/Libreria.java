package model;

import Utils.ValidadorRut;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Libreria {
	private List<Cliente> clientes;
	private List<Articulo> articulos;
		public Libreria() {
			this.clientes=new ArrayList<Cliente>();
			this.articulos= new ArrayList<Articulo>();
		}
		public List<Cliente> getClientes() {return clientes;}

		public List<Articulo> getArticulos() {return articulos;}

		public Cliente buscarCliente(String rut) {
			Cliente cliente= null;
			for (Cliente clienteAux : this.clientes) {
				if (clienteAux.getRut().equals(rut)) {
					clientes = (List<Cliente>) clienteAux;
					break;
				}
			}
			return (Cliente) clientes;
		}
		public Articulo buscarArticulos(String nombreArticulo){
			Articulo articulos = null;
			for (Articulo ariculosAux : this.articulos) {
				if (ariculosAux.getNombre().equals(nombreArticulo)) {
					articulos = ariculosAux ;
					break;
				}
			}
			return articulos;
		}
		public Articulo añadirArticulo(String nombre, String tipoArticulo , String peso, String precio){
			String[] data = new String[0];
			Articulo articulos= new Articulo(data[0], data[1], nombre);
			this.articulos.add(articulos);
			return articulos;
		}
	public List<Articulo> buscarArticulo(String nombre) {
		List<Articulo> articulos = new ArrayList<Articulo>();
		for (Articulo articulo : this.articulos) {
			if (Objects.equals(articulos.get(0), nombre)) {
				articulos.add(articulo);
			}
		}
		return articulos;
		}
		public List<Cliente> buscarClienteNombre(String nombre) {
			List<Cliente> clientes = new ArrayList<Cliente>();
			for (Cliente cliente : this.clientes) {
				if (cliente.getNombreCliente().equals(nombre)) {
					clientes.add(cliente);
				}
			}
			return clientes;
		}

		public boolean añadirCliente(String nombre,String campoRut, int correo) {
			if (ValidadorRut.validarDigito(campoRut) && this.buscarCliente(campoRut)==null) {
				Cliente cliente= new Cliente(nombre);
				this.clientes.add(cliente);
				return true;
			} else {
				return false;
			}
		}

	public List<Articulo> buscarNombreArticulo(String s) {
		return null;
	}

	public void añadirCliente(String text, campoRut selectedItem, int correo) {

	}

	public boolean añadirArticulo(String textoNombre, String textoTipoArticulo, double parsePeso, double parsePrecio) {
		return false;
	}
}