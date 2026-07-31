package com.example.inventario.model;

public abstract  class Producto {

    private String codigo;
    private String nombre;
    private String categoria;
    private Double precio;
    private int stock;


    // Constructor

    public Producto(String categoria, String codigo, String nombre, Double precio, int stock) {
        setCodigo(codigo);
        setNombre(nombre);
        setCategoria(categoria);
        setPrecio(precio);
        setStock(stock);
    }

public abstract double calcularValorInventario();

public String getCodigo() {
    return codigo;
}

public void setCodigo(String codigo) {
    if (codigo == null || codigo.isBlank()){
        throw new IllegalArgumentException("El codigo es obligatorio");
    }
    this.codigo = codigo.trim().toUpperCase();

}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre.trim();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()){
            throw new IllegalArgumentException("La categoria es obligatoria");
        }
        this.categoria = categoria.trim();
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        if (precio == null || precio <= 0){
            throw new IllegalArgumentException("El precio es obligatorio y debe ser mayor a 0");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0){
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }


    




}
