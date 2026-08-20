package com.curso.ventas.service;

import java.util.ArrayList;

import com.curso.ventas.model.Producto;
import com.curso.ventas.model.ResultadoVenta;
import com.curso.ventas.repository.ProductoRepository;

public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public String agregarProducto(String nombre, double precio, int stock) {
        if (nombre == null || nombre.isBlank()) {
            return "El nombre del producto no puede estar vacío.";
        }
        if (precio <= 0) {
            return "El precio del producto debe ser un valor positivo.";
        }
        if (stock < 0) {
            return "El stock del producto no puede ser un valor negativo.";
        }
        
        repository.guardar(nombre.trim(), precio, stock, "", "");
        return "OK";
    }

    public ArrayList<Producto> listarProductos() {
        return repository.listarTodos();
    }

    public Producto buscarProducto(int id) {
        return repository.buscarPorId(id);
    }

    public String actualizarProducto(int id, String nombre, double precio, int stock) {
        if (repository.buscarPorId(id) == null) {
            return "No se encontró un producto con el ID proporcionado.";
        }
         if (nombre == null || nombre.isBlank()) {
            return "El nombre del producto no puede estar vacío.";
         }
         if (precio <= 0) {
            return "El precio del producto debe ser un valor positivo.";
         }
         if (stock < 0) {
            return "El stock del producto no puede ser un valor negativo.";
         }
         repository.actualizar(id, nombre.trim(), precio, stock, "", "");
         return "OK";
    }

    public String eliminarProducto(int id) {
        if (repository.buscarPorId(id) == null) {
            return "No se encontró un producto con el ID proporcionado.";
        }
        repository.eliminar(id);
        return "OK";
    }

    public ResultadoVenta venderProducto(int id, int cantidad) {
        Producto producto = repository.buscarPorId(id);
        if (producto == null) {
            return ResultadoVenta.error("No se encontro el producto con el ID proporcionado.");
        }
        if (cantidad <= 0) {
            return ResultadoVenta.error("La cantidad a vender debe ser un valor positivo.");
        }
        if (producto.getStock() < cantidad) {
            return ResultadoVenta.error("No hay suficiente stock disponible para la venta. Disponible: " + producto.getStock() + ", solicitado: " + cantidad);
        }
        producto.reducirStock(cantidad);
        double totalVenta = producto.getPrecio() * cantidad;
        return ResultadoVenta.ok(totalVenta, producto.getStock());
    }

    public boolean estaVacio() {
        return repository.estaVacio();
    }

    public int cantidadProductos() {
        return repository.cantidad();
    }
}
