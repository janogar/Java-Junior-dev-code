package com.example.models;

public class ClienteEmpresarial extends Cliente {

    public ClienteEmpresarial(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    @Override
    public double calcularDescuento(double valorCompra) {
        if (valorCompra > 500000) {
            return valorCompra * 0.15;
        }
        return 0;
    }

    @Override
    public String obtenerTipoCliente() {
        return "Cliente Empresarial";
    }
}