package com.curso.ventas.model;

public class Producto {

    //test
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    private String descripcion;


    public Producto(int id, String nombre, double precio, int stock, String categoria, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "categoria='" + categoria + '\'' +
                "id=" + id +
                " | nombre='" + nombre + '\'' +
                " | precio= $" + String.format("%.2f", precio) +
                " | stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String getStockRestante() {
        return "Stock restante: " + stock;
        }
}
