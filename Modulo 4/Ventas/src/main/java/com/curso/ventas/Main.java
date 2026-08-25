package com.curso.ventas;

import com.curso.ventas.presentation.MenuConsola;
import com.curso.ventas.repository.ProductoRepository;
import com.curso.ventas.service.ProductoService;

public class Main {
    public static void main(String[] args) {
        ProductoRepository repository = new ProductoRepository();
        ProductoService service = new ProductoService(repository);
        MenuConsola menu = new MenuConsola(service);

        menu.iniciar();
    }
}