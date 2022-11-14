package com.misiontic.finappmovil.models;

public class TipoSucursal {

    private int id;
    private String tipo;

    public TipoSucursal(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoSucursal(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
