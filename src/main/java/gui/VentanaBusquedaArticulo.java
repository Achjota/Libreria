package gui;

import controller.LibreriaController;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaBusquedaArticulo extends Ventana{
	private LibreriaController libreriaController;
	private Libreria libreria;
	private JButton botonBuscar, botonRegresar;
	private JLabel textoEncabezado, textoNombre, textoArticulo;
	private JComboBox listaArticulo;
	private JTextField campoNombre;

	public VentanaBusquedaArticulo(Libreria libreria) {
		super("Búsqueda de Articulo");
		this.libreria = libreria;
		generarElementosVentana();
	}
	private void generarElementosVentana() {
		generarCampoNombre();
		generarBotonBuscarArticulo();
		generarBotonCancelar();
		generarListaArticulo();
	}
	private void generarCampoNombre(){
		String textoNombre= "Nombre Articulo:";
		super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
		this.campoNombre= super.generarJTextField(200,50,250,20);
		this.add(this.campoNombre);
	}
	private void generarListaArticulo(){
		super.generarJLabel(this.textoArticulo,"Lista De Articulos:",20,100,100,20);
		this.listaArticulo=super.generarListaDesplegable(NombreArticulo.values(),120,100, 100, 20);
		this.add(this.listaArticulo);
	}
	private void generarBotonBuscarArticulo() {
		String textoBoton= "Buscar Articulo";
		this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
		this.add(this.botonBuscar);
		this.botonBuscar.addActionListener(this);
	}
	private void generarBotonCancelar() {
		String textoBotonRegresar = "Regresar";
		this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
		this.add(this.botonRegresar);
		this.botonRegresar.addActionListener(this);
	}
	private String[][] registrarArticulo(){
		List<Articulo> articulos= new ArrayList<>();
		String[][] datosArticulos;
		if(this.campoNombre.getText().length()==0){
			System.out.println(this.listaArticulo.getSelectedItem());
			articulos= (List<Articulo>) libreria.buscarNombreArticulo(String.valueOf((NombreArticulo) this.listaArticulo.getSelectedItem()));
		}
		else{
			articulos= libreria.buscarNombreArticulo(String.valueOf((NombreArticulo) this.listaArticulo.getSelectedItem()));
		}
		System.out.println(articulos.size());
		datosArticulos= new String[articulos.size()][6];
		for(int i=0; i<articulos.size(); i++){
			datosArticulos[i][0]=articulos.get(i).getNombre();
			datosArticulos[i][1]=articulos.get(i).getTipoArticulo();
			datosArticulos[i][2]= Integer.toString((int) articulos.get(i).getPeso());
			datosArticulos[i][3]= String.valueOf(articulos.get(i).getPrecio());
		}
		return datosArticulos;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonBuscar){
			String[] nombreColumnas={"Nombre","Tipo de Articulo","Peso","Precio"};
			VentanaTabla ventanaTabla= new VentanaTabla(registrarArticulo(),nombreColumnas);
		}
		if (e.getSource() == this.botonRegresar){
			VentanaInicio ventanaInicio = new VentanaInicio(libreria);
			this.dispose();
		}

	}
}