package com.example.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase base abstracta para representar clientes del sistema.
 */
public abstract class Cliente {

    private int id;
    private String nombre;
    private String correo;
    private List<AccionHistorial> historial;

    public Cliente(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.historial = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public List<AccionHistorial> getHistorial() {
        return historial;
    }

    public void agregarAccion(String fecha, String descripcion) {
        historial.add(new AccionHistorial(fecha, descripcion));
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El cliente no tiene acciones registradas.");
        } else {
            for (AccionHistorial accion : historial) {
                accion.mostrarAccion();
            }
        }
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Tipo: " + obtenerTipoCliente());
    }

    public abstract double calcularDescuento(double valorCompra);

    public abstract String obtenerTipoCliente();
}
