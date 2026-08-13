package com.curso.ventas.model;

public class ResultadoVenta {

    private final boolean exitoso;
    private final String mensaje;
    private final double total;
    private final int stockRestante;

    public ResultadoVenta(boolean exitoso, String mensaje, double total, int stockRestante) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
        this.total = total;
        this.stockRestante = stockRestante;
    }

    public static ResultadoVenta ok(double total, int stockRestante) {
        return new ResultadoVenta(true,"venta realizada con exito", total, stockRestante);
    }

    public static ResultadoVenta error(String mensaje) {
        return new ResultadoVenta(false, mensaje, 0, 0);
    }

    public  boolean esExitoso(){
        return exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public double getTotal() {
        return total;
    }

    public int getStockRestante() {
        return stockRestante;
    }
}
