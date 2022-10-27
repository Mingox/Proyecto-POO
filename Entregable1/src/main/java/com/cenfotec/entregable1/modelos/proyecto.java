package com.cenfotec.entregable1.modelos;

public class proyecto {

    private String nombre;
    private String Categoria;
    private String fechaCreacion;
    private String UltimaModificacion;

    public proyecto(String nombre, String categoria, String fechaCreacion, String ultimaModificacion) {
        this.nombre = nombre;
        Categoria = categoria;
        this.fechaCreacion = fechaCreacion;
        UltimaModificacion = ultimaModificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUltimaModificacion() {
        return UltimaModificacion;
    }

    public void setUltimaModificacion(String ultimaModificacion) {
        UltimaModificacion = ultimaModificacion;
    }

    @Override
    public String toString() {
        return "proyecto{" +
                "nombre='" + nombre + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", UltimaModificacion='" + UltimaModificacion + '\'' +
                '}';
    }
}//Fin programa
