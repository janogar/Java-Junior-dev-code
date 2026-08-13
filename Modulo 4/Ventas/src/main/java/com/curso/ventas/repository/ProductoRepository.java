package com.curso.ventas.repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.curso.ventas.model.Producto;

public class ProductoRepository {

    private final HashMap<Integer, Producto> productosPorId = new HashMap<>();
    private int siguienteId = 1;

    public Producto guardar(String nombre, double precio, int stock, String categoria, String descripcion) {
        Producto nuevo = new Producto(siguienteId, nombre, precio, stock, categoria, descripcion);
        productosPorId.put(siguienteId,nuevo);
        siguienteId++;
        return nuevo;
    }

    public ArrayList<Producto> listarTodos(){
        return new ArrayList<>(productosPorId.values());
    }

    public Producto buscarPorId(int id) {
        return productosPorId.get(id);
    }

    public boolean actualizar(int id, String nombre, double precio, int stock, String categoria, String descripcion) {
        Producto producto = buscarPorId(id);
        if (producto == null) {
            return false;
        }
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setCategoria(categoria);
        producto.setDescripcion(descripcion);
        return true;
    }

    public boolean eliminar(int id) {
        if (!productosPorId.containsKey(id)) {
            return false;
        }
        productosPorId.remove(id);
        return true;
    }


    public boolean estaVacio() {
        return productosPorId.isEmpty();
    }

    public int cantidad(){
        return productosPorId.size();
    }


}
