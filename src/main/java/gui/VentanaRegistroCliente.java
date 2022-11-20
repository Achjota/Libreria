package gui;

import controller.LibreriaController;
import model.Cliente;
import model.Libreria;
import model.campoRut;
import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistroCliente extends Ventana {
	private LibreriaController libreriaController;
	private JLabel textoEncabezado, textoNombreCliente, textoRut, textoCorreo;
	private JTextField campoNombreCliente, campoRut, campoCorreo;
	private JButton botonRegistrar, botonCancelar;
	private JComboBox listaClientes;
	private Libreria libreria;

	private void generarEncabezado() {
		String textoCabecera = "Registro de Clientes";
		super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

	}

	public VentanaRegistroCliente(Libreria libreria) {
		super("Registro de Cliente");
		this.libreria = libreria;
		generarElementosVentana();

	}

	private void generarElementosVentana() {
		generarEncabezado();
		generarCampoNombreCliente();
		generarCampoRut();
		generarCampoCorreo();
		generarBotonRegistrar();
		generarBotonCancelar();
		generarListaClientes();
	}

	private void generarListaClientes() {
		super.generarJLabel(this.textoNombreCliente, "Nombre Cliente:", 20, 100, 100, 20);
		String[] arreglo = new String[]{"ICI", "ICI-I"};
		this.listaClientes = super.generarListaDesplegable(arreglo, 120, 100, 100, 20);
		this.add(this.listaClientes);
	}

	private void generarBotonRegistrar() {
		String textoBoton = "Registrar Cliente";
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

	private void generarCampoNombreCliente() {
		String textoNombre = "Nombre Cliente:";
		super.generarJLabel(this.textoNombreCliente, textoNombre, 20, 50, 150, 20);
		this.campoNombreCliente = super.generarJTextField(200, 50, 250, 20);
		this.add(this.campoNombreCliente);
	}

	private void generarCampoRut() {
		super.generarJLabel(this.textoRut, "Rut:", 20, 150, 200, 20);
		InternationalFormatter formato = super.generarFormato(1950);
		this.campoRut = super.generarJFormattedTextField(formato, 200, 150, 250, 20);
		this.add(this.campoRut);
	}

	private void generarCampoCorreo() {
		super.generarJLabel(this.textoCorreo, "Correo:", 20, 200, 200, 20);
		InternationalFormatter formato = super.generarFormato(0);
		this.campoCorreo = super.generarJFormattedTextField(formato, 200, 200, 250, 20);
		this.add(this.campoCorreo);
	}

	private boolean registrarCliente() {
		if (this.campoNombreCliente.getText().length() == 0 || this.campoRut.getText().length() == 0 ||
				this.campoCorreo.getText().length() == 0) {
			return false;
		} else {

			return true;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.botonRegistrar) {
			if (registrarCliente()) {
				libreria.añadirCliente(this.campoNombreCliente.getText(), (campoRut) this.listaClientes.getSelectedItem(), Integer.parseInt(this.campoCorreo.getText()));
				JOptionPane.showMessageDialog(this, "Cliente Registrado Correctamente", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
				VentanaInicio ventanaInicio = new VentanaInicio(libreria);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == this.botonCancelar) {
			VentanaInicio ventanaInicio = new VentanaInicio(libreria);
			this.dispose();
		}

	}
}