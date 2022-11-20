package model;

public enum NombreCliente {;

    private String nombreCliente;

    private NombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {return nombreCliente;}
}

