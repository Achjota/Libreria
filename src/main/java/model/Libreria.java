package model;

import model.Articulos;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Libreria {
	private List<Cliente> clientes;
	private List<Articulos> articulos;
		public Libreria() {
			this.clientes=new ArrayList<Cliente>();
			this.articulos= new ArrayList<Articulos>();
		}
		public List<Cliente> getClientes() {return clientes;}

		public List<Articulos> getArticulos() {return articulos;}

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
		public Articulos buscarArticulos(String nombreArticulo){
			Articulos articulos = null;
			for (Articulos ariculosAux : this.articulos) {
				if (ariculosAux.getNombre().equals(nombreArticulo)) {
					articulos = ariculosAux ;
					break;
				}
			}
			return articulos;
		}
		public Articulos añadirArticulos(String nombre, String tipoArticulo , double peso, double precio){
			Articulos articulos= new Articulos(nombre);
			this.articulos.add(articulos);
			return articulos;
		}
		public List<Articulos> buscarNombreArticulo(String nombre) {
			List<Articulos> articulos = new ArrayList<Articulos>();
			for (Articulos articulos : this.articulos) {
				if (articulos.getNombre().equals(nombre)) {
					articulos.add(articulos);
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

		public boolean añadirCliente(String nombre,String rut,String correo) {
			if (ValidadorRut.validarDigito(rut) && this.buscarCliente(rut)==null) {
				Cliente cliente= new Cliente(nombre,rut,correo);
				this.clientes.add(cliente);
				return true;
			} else {
				return false;
			}
		}
	}