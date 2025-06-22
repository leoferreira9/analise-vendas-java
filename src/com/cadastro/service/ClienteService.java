package com.cadastro.service;

import com.cadastro.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Cliente buscarClientePorId(int id){
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Cliente buscarClientePorCPF(String cpf){
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> listarClientes(){
        return clientes;
    }
}
