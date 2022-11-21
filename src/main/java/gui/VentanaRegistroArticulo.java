package gui;

import controller.LibreriaController;
import model.Libreria;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistroArticulo extends Ventana{
	private LibreriaController libreriaController;
	private JLabel textoEncabezado, textoPrecio, textoNombre, textoPeso, textoTipoArticulo;
	private JTextField campoPrecio, campoNombre, campoPeso, campoTipoArticulo;
	private JButton botonRegistrar, botonCancelar;
	private Libreria libreria;

	public VentanaRegistroArticulo(Libreria libreria){
		super("Registro de Articulo");
		this.libreria= libreria;
		generarElementosVentana();
	}
	private void generarElementosVentana() {
		generarEncabezado();
		generarBotonCancelar();
		generarBotonRegistrar();
		generarCampoTipoArticulo();
		generarCampoNombre();
		generarCampoPeso();
		generarCampoPrecio();
	}
	private void generarEncabezado() {
		String textoCabecera = "Registro de Articulo";
		super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);
	}
	private void generarBotonRegistrar() {
		String textoBoton= "Registrar Articulo";
		this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
		this.add(this.botonRegistrar);
		this.botonRegistrar.addActionListener(this);
	}
	private void generarBotonCancelar() {
		String textoBotonCancelar = "Cancelar";
		this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
		this.add(this.botonCancelar);
		this.botonCancelar.addActionListener(this);
	}
	private void generarCampoNombre(){
		String textoNombre= "Nombre:";
		super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
		this.campoNombre= super.generarJTextField(200,50,250,20);
		this.add(this.campoNombre);
	}
	private void generarCampoPrecio(){
		String textoRut= "Precio:";
		super.generarJLabel(this.textoPrecio, String.valueOf(textoPrecio),20,100,150,20);
		this.campoPrecio= super.generarJTextField(200,100,250,20);
		this.add(this.campoPrecio);
	}
	private void generarCampoTipoArticulo(){
		String textoDireccion= "Tipo de Articulo:";
		super.generarJLabel(this.textoTipoArticulo, String.valueOf(textoTipoArticulo),20,150,150,20);
		this.campoTipoArticulo= super.generarJTextField(200,150,250,20);
		this.add(this.campoTipoArticulo);
	}
	private void generarCampoPeso(){
		String textoNumero= "Peso de objeto:";
		super.generarJLabel(this.textoPeso, String.valueOf(textoPeso), 20,250,150,20);
		this.campoPeso= super.generarJTextField(200,250,250,20);
		this.add(this.campoPeso);
	}
	private boolean registrarArticulo(){
		return libreria.añadirArticulo(this.campoNombre.getText(),this.campoPrecio.getText(), Double.parseDouble(this.campoTipoArticulo.getText()), Integer.parseInt(this.campoPeso.getText()));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.botonRegistrar) {
			if (registrarArticulo()) {
				JOptionPane.showMessageDialog(this,"Ingrese un articulo válido");
			} else {
				JOptionPane.showMessageDialog(this,"Articulo registrado correctamente");
				VentanaInicio ventanaInicio = new VentanaInicio(libreria);
				this.dispose();
			}

		}
		if (e.getSource() == this.botonCancelar){
			VentanaInicio ventanaInicio = new VentanaInicio(libreria);
			this.dispose();
		}

	}
}