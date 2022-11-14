package com.misiontic.finappmovil.models;

public class Sucursal {
    private int id;
    private int tipoSucursal;
    private String direccion;
    private String nitBanco;

    public Sucursal() {
    }

    public Sucursal(int tipoSucrusal, String direccion, String nitBanco) {
        this.tipoSucursal = tipoSucrusal;
        this.direccion = direccion;
        this.nitBanco = nitBanco;
    }

    public Sucursal(int id, int tipoSucrusal, String direccion, String nitBanco) {
        this.id = id;
        this.tipoSucursal = tipoSucrusal;
        this.direccion = direccion;
        this.nitBanco = nitBanco;
    }

    public String getNitBanco() {
        return nitBanco;
    }

    public void setNitBanco(String nitBanco) {
        this.nitBanco = nitBanco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(int tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
