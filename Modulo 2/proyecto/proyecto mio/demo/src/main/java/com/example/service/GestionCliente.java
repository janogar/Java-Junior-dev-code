package com.example.service;

import com.example.models.Cliente;

public interface  GestionCliente {

    void registrarCliente(Cliente cliente);

    void listarClientes();

    Cliente buscarPorCorreo(String correo);

    void registrarAccion(String correo, String fecha, String descripcion);


}
