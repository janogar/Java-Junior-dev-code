package com.example.services;

import com.example.models.Cliente;

/**
 * Define las operaciones principales para gestionar clientes.
 */
public interface GestionCliente {

    void registrarCliente(Cliente cliente);

    void listarClientes();

    Cliente buscarPorCorreo(String correo);

    void registrarAccion(String correo, String fecha, String descripcion);
}
