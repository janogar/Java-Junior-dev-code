package com.example.models;

public class ClienteBasico extends Cliente {

    public ClienteBasico(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    @Override
    public double calcularDescuento(double valorCompra) {
        return 0;
    }

    @Override
    public String obtenerTipoCliente() {
        return "Cliente Básico";
    }
}