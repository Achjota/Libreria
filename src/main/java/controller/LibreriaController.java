package controller;

import data.GestorDatos;
import model.Libreria;

public class LibreriaController {
    public static Libreria cargaMasivaDatos(Libreria libreria) {
        GestorDatos.leerArchivoArticulos(libreria, "Articulos.txt");
        GestorDatos.leerArchivoCliente(libreria, "Clientes.txt");
        return libreria;
    }

    public static void almacenarDatos(Libreria libreria) {
        GestorDatos.registrarDatos(libreria.getArticulos(), "Articulos.txt");
        GestorDatos.registrarDatos(libreria.getClientes(), "Clientes.txt");
    }
}