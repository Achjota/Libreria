package com.example.libreria;

import gui.Ventana;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Ventana {

    protected HelloApplication(String nombre) {
        super(nombre);
    }
}