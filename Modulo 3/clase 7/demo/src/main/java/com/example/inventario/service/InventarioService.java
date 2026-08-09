package com.example.inventario.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.example.inventario.model.Producto;



public final class InventarioService {

    private final static InventarioService INSTANCIA = new InventarioService();

    private final Map<String, Producto> productoPorCodigo = new LinkedHashMap<>();

    private final Set<String> categorias = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    private InventarioService() {
        categorias.add("Bebidas");
        categorias.add("Lácteos");
    }

    public static InventarioService getInstancia() {
        return INSTANCIA;
    }

    //create services
    public synchronized void registrar(Producto producto) {
        validarProducto(producto);
        String codigo = normalizarCodigo(producto.getCodigo());
        if (productoPorCodigo.containsKey(codigo)) {
            throw new IllegalArgumentException("El producto con código " + codigo + " ya está registrado.");
        }
        productoPorCodigo.put(codigo, producto);
        categorias.add(producto.getCategoria());
    }

    //update services
    public synchronized void actualizar(Producto producto) {
        validarProducto(producto);
        String codigo = normalizarCodigo(producto.getCodigo());
        if (!productoPorCodigo.containsKey(codigo)) {
            throw new IllegalArgumentException("El producto con código " + codigo + " no está registrado.");
        }
        productoPorCodigo.put(codigo, producto);
        categorias.add(producto.getCategoria());
    }

    //delete services
    public synchronized boolean eliminar(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return false; 
        }
        return productoPorCodigo.remove(normalizarCodigo(codigo)) != null;
    }

    //read services

    public synchronized Optional<Producto> buscar(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return Optional.empty();
        }
        return Optional.ofNullable(productoPorCodigo.get(normalizarCodigo(codigo)));
    }

    //read services grid
    public synchronized List<Producto> listarOrdenadosPorNombre() {
        List<Producto> resultado = new ArrayList<>(productoPorCodigo.values());
        resultado.sort(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER));
        return resultado;
    }

    public synchronized List<Producto> filtrarPorCategoriaList(String categoria) {
        List<Producto> resultado = new ArrayList<>(productoPorCodigo.values());
        for (Producto producto : productoPorCodigo.values()){
            if(producto.getCategoria().equalsIgnoreCase(categoria)){
                resultado.add((producto));
            }
        }
        resultado.sort(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER));
        return resultado;
    }

    public synchronized Set<String> obtenerCategorias(){
        return new TreeSet<>(categorias);
    }
    private void validarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
    }

    private String normalizarCodigo(String codigo) {
        return codigo.trim().toUpperCase();
    }
}



    

