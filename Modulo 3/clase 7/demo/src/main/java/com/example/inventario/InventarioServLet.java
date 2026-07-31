package com.example.inventario;

import com.vaadin.flow.server.VaadinServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*", name = "InventarioServlet", asyncSupported = true)
public class InventarioServlet extends VaadinServlet {
}