package com.example.models;

public class ClientePremium extends Cliente {

    public ClientePremium(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    @Override
    public double calcularDescuento(double valorCompra) {
        if (valorCompra > 100000) {
            return valorCompra * 0.10;
        }
        return 0;
    }

    @Override
    public String obtenerTipoCliente() {
        return "Cliente Premium";
    }
}