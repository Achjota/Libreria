package com.example.libreria;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/Bienvenida")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Libreria Jota";
    }
}