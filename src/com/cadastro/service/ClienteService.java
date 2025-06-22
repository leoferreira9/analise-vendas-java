package com.cadastro.service;

import com.cadastro.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
    private static int proximoId = 1000;

    public void adicionarCliente(Cliente cliente){

        if(buscarClientePorCPF(cliente.getCpf()) != null){
            System.out.println("CPF já cadastrado!");
        } else if (buscarClientePorEmail(cliente.getEmail()) != null){
            System.out.println("Email já cadastrado!");
        } else {
            clientes.add(cliente);
            System.out.println("✅ Cliente cadastrado com sucesso! ID: " + cliente.getId());
        }
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

    public Cliente buscarClientePorEmail(String email){
        return clientes.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> listarClientes(){
        return clientes;
    }

    public int gerarNovoId(){
        return proximoId++;
    }
}
