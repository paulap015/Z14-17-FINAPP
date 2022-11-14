package com.misiontic.finappmovil.models;

public class Banco {
    private int id  ;
    private String nombre;
    private String nit  ;

    public Banco(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public Banco(int id, String nombre, String nit) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
