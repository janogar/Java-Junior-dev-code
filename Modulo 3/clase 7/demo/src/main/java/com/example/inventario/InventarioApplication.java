package com.example.inventario;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.server.PWA;


@Push
@PWA(name = "Gestion de inventario", shortName = "Inventario")
public class InventarioApplication implements AppShellConfigurator {
}