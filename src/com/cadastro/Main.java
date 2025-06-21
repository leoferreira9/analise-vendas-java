package com.cadastro;

import com.cadastro.model.Cliente;
import com.cadastro.model.Pedido;
import com.cadastro.model.StatusPedido;
import com.cadastro.service.PedidoService;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("Leonardo", "000.888.222-37", 1910, "leo@email.com");
        Cliente c2 = new Cliente("Joel", "123.233.545-66", 2231, "joel@email.com");

        Pedido p1 = new Pedido(33133, c1, StatusPedido.PENDENTE);
        Pedido p2 = new Pedido(55634, c2, StatusPedido.ENVIADO);
        Pedido p3 = new Pedido(12332, c1, StatusPedido.PROCESSANDO);

        PedidoService ps = new PedidoService();
        ps.adicionarPedido(p1);
        ps.adicionarPedido(p2);
        ps.adicionarPedido(p3);

        System.out.println("📦 Todos os pedidos:");
        ps.listarPedidos().forEach(System.out::println);

        System.out.println("\n📦 Pedidos pendentes:");
        ps.buscarPedidosPorStatus(StatusPedido.PENDENTE).forEach(System.out::println);

        ps.atualizarStatusPedido(33133, StatusPedido.ENVIADO);

        System.out.println("\n📦 Pedidos após atualização:");
        ps.listarPedidos().forEach(System.out::println);
    }
}
