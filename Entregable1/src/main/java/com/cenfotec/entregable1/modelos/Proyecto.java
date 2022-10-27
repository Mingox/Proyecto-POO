package com.cenfotec.entregable1.modelos;

public class Proyecto {

    private String nombre;



    private String Categoria;
    private String fechaCreacion;
    private String UltimaModificacion;

    private String repositorio;

    public Proyecto(String nombre, String categoria, String fechaCreacion, String ultimaModificacion, String repositorio) {
        this.nombre = nombre;
        this.Categoria = categoria;
        this.fechaCreacion = fechaCreacion;
        this.UltimaModificacion = ultimaModificacion;
        this.repositorio = repositorio;
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

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
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
