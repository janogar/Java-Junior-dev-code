package com.example.inventario.model;

public class ProductoElectronico extends Producto {

    private static final double COSTO_SEGURO_MENSUAL = 2.5;

    private int mesesGarantia;

    public ProductoElectronico(String categoria, String codigo, String nombre, Double precio, int stock,
            int mesesGarantia) {
        super(categoria, codigo, nombre, precio, stock);
        SetMesesGarantia(mesesGarantia);
    }

    @Override
    public double calcularValorInventario() {
        double valorBase = mesesGarantia * COSTO_SEGURO_MENSUAL;
        return getPrecio() * getStock() + valorBase;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void SetMesesGarantia(int mesesGarantia) {
        if (mesesGarantia < 0) {
            throw new IllegalArgumentException("Los meses de garantia no pueden ser negativos");
        }
        this.mesesGarantia = mesesGarantia;
    }
}
