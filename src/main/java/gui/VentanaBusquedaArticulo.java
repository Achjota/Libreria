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
		List<Articulos> articulos= new ArrayList<>();
		String[][] datosArticulos;
		if(this.campoNombre.getText().length()==0){
			System.out.println(this.listaArticulo.getSelectedItem());
			articulos= (List<Articulos>) libreria.buscarNombreArticulo(String.valueOf((NombreArticulo) this.listaArticulo.getSelectedItem()));
		}
		else{
			articulos= .libreria.buscarNombreArticulo();
		}
		System.out.println(articulos.size());
		datosArticulos= new String[articulos.size()][6];
		for(int i=0; i<articulos.size(); i++){
			datosEstudiantes[i][0]=estudiantes.get(i).getNombre();
			datosEstudiantes[i][1]=estudiantes.get(i).getRut();
			datosEstudiantes[i][2]= Integer.toString(estudiantes.get(i).getNumeroMatricula());
			datosEstudiantes[i][3]=estudiantes.get(i).getApellido();
		}
		return datosEstudiantes;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonBuscar){
			String[] nombreColumnas={"Nombre","Rut","Numero Matricula","Apellido"};
			VentanaTabla ventanaTabla= new VentanaTabla(registrarEstudiante(),nombreColumnas);
		}
		if (e.getSource() == this.botonRegresar){
			VentanaBienvenida ventanaBienvenida = new VentanaBienvenida(universidad);
			this.dispose();
		}

	}
}