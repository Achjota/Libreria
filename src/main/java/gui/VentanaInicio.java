package gui;

import controller.LibreriaController;
import model.Libreria;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaInicio extends Ventana{
    private LibreriaController libreriaController;
    private JLabel textoMenu;
    private JButton botonRegistrarCliente;
    private JButton botonSalida;
    private JButton botonRegistrarArticulo;
    private JButton botonBuscarArticulo;
    private Libreria libreria;
    private JPanel panelBienvenida;



    public VentanaInicio(){
        super("Bienvenida");
        add(panelBienvenida);
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public VentanaInicio(Libreria libreria) {
        super("Bienvenida");
        this.libreria = libreria;
        generarElementosVentana();
    }
    protected VentanaInicio(String nombre) {
        super(nombre);
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarArticulo();
        generarBotonRegistrarCliente();
        generarBotonBuscarArticulo();
        generarBotonSalir();
    }
    private void generarMensajeMenu() {
        String textoBienvenida = "Libreria Jota";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }
    private void generarBotonRegistrarArticulo() {
        String textoBoton = "Registrar Articulo";
        this.botonRegistrarArticulo = super.generarBoton(textoBoton, 175, 100, 150, 40);
        this.add(this.botonRegistrarArticulo);
        this.botonRegistrarArticulo.addActionListener(this);
    }
    private void generarBotonRegistrarCliente() {
        String textoBoton = "Registrar Cliente";
        this.botonRegistrarCliente = super.generarBoton(textoBoton, 175, 180, 150, 40);
        this.add(this.botonRegistrarCliente);
        this.botonRegistrarCliente.addActionListener(this);
    }
    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }
    private void generarBotonBuscarArticulo(){
        String textoBoton = "Buscar Articulo";
        this.botonBuscarArticulo=super.generarBoton(textoBoton, 175, 260, 150, 40);
        this.add(this.botonBuscarArticulo);
        this.botonBuscarArticulo.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarArticulo) {
            VentanaRegistroArticulo ventanaRegistrarArticulo= new VentanaRegistroArticulo(libreria);
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonRegistrarCliente){
            VentanaRegistroCliente ventanaRegistroCliente= new VentanaRegistroCliente(libreria);
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarArticulo){
            VentanaBusquedaArticulo ventanaBusquedaArticulo= new VentanaBusquedaArticulo(libreria);
            this.dispose();
        }
        if(e.getSource() == this.botonSalida){
            LibreriaController.almacenarDatos(this.libreria);
            this.dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new VentanaInicio("Bienvenida");
        frame.setVisible(true);

    }

}