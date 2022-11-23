package com.cenfotec.entregable1.modelos;

public class Media {
    private String Archivo;
    private String Autor;
    private String Fecha;

    public Media(String archivo, String autor, String fecha) {
        Archivo = archivo;
        Autor = autor;
        Fecha = fecha;
    }

    public String getArchivo() {
        return Archivo;
    }

    public void setArchivo(String archivo) {
        Archivo = archivo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    @Override
    public String toString() {
        return "Media{" +
                "Archivo='" + Archivo + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Fecha='" + Fecha + '\'' +
                '}';
    }
}
