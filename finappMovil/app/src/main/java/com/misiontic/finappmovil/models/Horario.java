package com.misiontic.finappmovil.models;

public class Horario {

    private int id;
    private String dia;
    private String rangoHoras;

    public Horario(int id, String dia, String rangoHoras) {
        this.id = id;
        this.dia = dia;
        this.rangoHoras = rangoHoras;
    }

    public Horario(String dia, String rangoHoras) {
        this.dia = dia;
        this.rangoHoras = rangoHoras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getRangoHoras() {
        return rangoHoras;
    }

    public void setRangoHoras(String rangoHoras) {
        this.rangoHoras = rangoHoras;
    }
}
