package com.cadastro.model;

public class Pedido {

    private int numero;
    private Cliente cliente;
    private StatusPedido status;

    Pedido(int numero, Cliente cliente, StatusPedido status){
        this.numero = numero;
        this.cliente = cliente;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cliente: " + getCliente().getNome() +
                "\nNúmero do pedido: " + getNumero() +
                "\nStatus: " + getStatus();
    }
}
