package com.cenfotec.entregable1.modelos;

public class Investigacion {
    private String Titulo;
    private String Subtitulo;
    private String Categoria;
    private String Tema;
    private String Autor;
    private String FechaInicio;
    private String FechaModificacion;

    public Investigacion(String titulo, String subtitulo, String categoria, String tema, String autor, String fechaInicio, String fechaModificacion) {
        Titulo = titulo;
        Subtitulo = subtitulo;
        Categoria = categoria;
        Tema = tema;
        Autor = autor;
        FechaInicio = fechaInicio;
        FechaModificacion = fechaModificacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getSubtitulo() {
        return Subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        Subtitulo = subtitulo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        Tema = tema;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        FechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Investigacion{" +
                "Titulo='" + Titulo + '\'' +
                ", Subtitulo='" + Subtitulo + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Tema='" + Tema + '\'' +
                ", Autor='" + Autor + '\'' +
                ", FechaInicio='" + FechaInicio + '\'' +
                ", FechaModificacion='" + FechaModificacion + '\'' +
                '}';
    }
}
