package com.example.inventario;

import com.vaadin.flow.server.VaadinServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*", name = "InventarioServLet", asyncSupported = true)
public class InventarioServLet extends VaadinServlet {
}