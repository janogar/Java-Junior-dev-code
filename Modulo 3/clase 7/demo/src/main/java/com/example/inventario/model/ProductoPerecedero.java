package com.example.inventario.model;

public class ProductoPerecedero extends Producto {

    private int diasParaVencer;

    public ProductoPerecedero(String categoria, String codigo, String nombre, Double precio, int stock,
            int diasParaVencer) {
        super(categoria, codigo, nombre, precio, stock);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcularValorInventario() {
        double valorBase = getPrecio() * getStock();
        if (diasParaVencer <= 3) {
            return valorBase * 0.5;
        }
        if (diasParaVencer <= 7) {
            return valorBase * 0.8;
        } else {
            return valorBase;
        }
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        if (diasParaVencer < 0) {
            throw new IllegalArgumentException("Los dias para vencer no pueden ser negativos");
        }
        this.diasParaVencer = diasParaVencer;
    }


}
