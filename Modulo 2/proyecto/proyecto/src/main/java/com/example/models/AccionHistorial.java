package com.example.models;

public class AccionHistorial {
    private String fecha;
    private String descripcion;

    public AccionHistorial(String fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void mostrarAccion() {
        System.out.println("Fecha: " + fecha + " | Acción: " + descripcion);
    }
}
