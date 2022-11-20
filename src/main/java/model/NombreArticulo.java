package model;

public enum NombreArticulo {;

    private String nombreArticulo;

    private NombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }
}

