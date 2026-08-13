package com.curso.ventas.repository;

import java.util.HashMap;}

import com.curso.ventas.model.Producto;

public class ProductoRepository {

    private final HashMap<Integer, Producto> productosPorId = new HashMap<>();
    private int siguienteId = 1;

    public Producto guardar(String nombre, double precio, int stock) {
        Producto nuevo= new Producto(siguienteId, nombre, stock, precio);
        productosPorId.put(siguienteId,nuevo);
        siguienteId++;
        return nuevo;

        //minuto 49:46
    }
}
