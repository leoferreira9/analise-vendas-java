package com.cadastro.service;

import com.cadastro.model.Pedido;
import com.cadastro.model.StatusPedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private List<Pedido> pedidos = new ArrayList<>();
    private static int proximoNumeroPedido = 1;

    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public List<Pedido> listarPedidos(){
       return pedidos;
    }

    public List<Pedido> buscarPedidosPorStatus(StatusPedido status){
        return pedidos.stream().filter(p -> p.getStatus().equals(status)).toList();
    }

    public void atualizarStatusPedido(int numero, StatusPedido novoStatus){
        Pedido pedido = pedidos.stream().filter(p -> p.getNumero() == numero).findFirst().orElse(null);

        if(pedido == null){
            System.out.println("❌ Pedido não encontrado!");
        } else {
            pedido.setStatus(novoStatus);
            System.out.println("\n✅ Status do pedido (" + pedido.getNumero() + ") atualizado para: " + novoStatus);
        }
    }

    public int gerarNovoNumeroPedido(){
        return proximoNumeroPedido++;
    }
}
