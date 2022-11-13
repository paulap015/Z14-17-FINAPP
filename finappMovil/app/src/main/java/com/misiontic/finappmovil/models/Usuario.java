package com.misiontic.finappmovil.models;

public class Usuario {
    private int id    ;
    private String tipoDocumento ;
    private String  documento   ;
    private String nombre;
    private String  correo  ;
    private String clave   ;

    private static int valorId=0;
    public Usuario() {
    }

    public Usuario(String tipo_documento, String documento, String nombre, String correo, String clave) {
        valorId+=1;
        this.tipoDocumento = tipo_documento;
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        //this.id =valorId;

    }

    public Usuario(int id, String tipoDocumento, String documento, String nombre, String correo, String clave) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        valorId+=1;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
