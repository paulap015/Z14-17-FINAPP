package com.misiontic.finappmovil.models;

public class HorarioSucursal {

    private int id;
    private int sucursalId;
    private int horarioId;

    public HorarioSucursal(int id, int sucursalId, int horarioId) {
        this.id = id;
        this.sucursalId = sucursalId;
        this.horarioId = horarioId;
    }

    public HorarioSucursal(int sucursalId, int horarioId) {
        this.sucursalId = sucursalId;
        this.horarioId = horarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }
}
