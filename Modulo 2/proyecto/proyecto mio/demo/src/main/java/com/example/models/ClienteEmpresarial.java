package com.example.models;

public class ClienteEmpresarial extends Cliente {

    public ClienteEmpresarial(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    @Override
    public double calcularDescuento(double valorCompra) {
        return 0.15 * valorCompra;
    }

    @Override
    public String obtenerTipoCliente() {
        return "Cliente empresarial";
    }

    

}
