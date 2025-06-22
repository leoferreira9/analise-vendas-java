package com.cadastro;

import com.cadastro.model.Cliente;
import com.cadastro.model.Pedido;
import com.cadastro.model.StatusPedido;
import com.cadastro.service.ClienteService;
import com.cadastro.service.PedidoService;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ClienteService clienteService = new ClienteService();
    static PedidoService pedidoService = new PedidoService();
    static StatusPedido[] status = StatusPedido.values();

    public static void main(String[] args) {

        int option;

        do{
            System.out.println(
                    "\n -----  MENU  ----- " +
                            "\nEscolha uma das opções abaixo:" +
                            "\n1) Cadastrar Cliente" +
                            "\n2) Novo Pedido" +
                            "\n3) Listar clientes cadastrados" +
                            "\n4) Listar todos os pedidos" +
                            "\n5) Buscar pedidos por status" +
                            "\n6) Atualizar status de um pedido" +
                            "\n7) Sair"
            );

            option = sc.nextInt();

            switch (option){
                case 1:
                    criarCliente();
                    break;
                case 2:
                    novoPedido();
                    break;
                case 3:
                    if(clienteService.listarClientes().size() == 0){
                        System.out.println("Não há clientes cadastrados");
                    } else {
                        clienteService.listarClientes().forEach(System.out::println);
                    }
                    break;
                case 4:
                    if(pedidoService.listarPedidos().size() == 0){
                        System.out.println("Não há pedidos!");
                    } else {
                        pedidoService.listarPedidos().forEach(System.out::println);
                    }
                    break;
                case 5:
                    buscarPedido();
                    break;
                case 6:
                    atualizarStatus();
                    break;
                case 7:
                    System.out.println("Encerrando...");
                    break;
            }

        } while(option != 7);
    }


    static void criarCliente(){

        String nome;
        String cpf;
        String email;

        do{
            System.out.println("Digite seu nome: ");
            sc.nextLine();
             nome = sc.nextLine();
        }while(nome.isEmpty());

        do{
            System.out.println("Digite seu CPF: ");
            cpf = sc.nextLine();
        }while(cpf.isEmpty());

        do{
            System.out.println("Digite seu Email: ");
            email = sc.nextLine();
        }while(email.isEmpty());

        Random random = new Random();
        int id = 1000 + random.nextInt(9000);

        clienteService.adicionarCliente(new Cliente(nome, cpf, id, email));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    static void novoPedido(){
        int id = 0;

        do{
            System.out.println("Informe o ID do cliente dono do pedido: ");
            id = sc.nextInt();
        } while(id == 0);

        Cliente c = clienteService.buscarClientePorId(id);

        if(c == null){
            System.out.println("Cliente não encontrado com ID: " + id);
            return;
        }

        Random random = new Random();
        int numero = 1000 + random.nextInt(9000);

        pedidoService.adicionarPedido(new Pedido(numero, c, StatusPedido.PENDENTE));
        System.out.println("Pedido criado com sucesso!");
    }

    static void buscarPedido(){

        if(pedidoService.listarPedidos().size() == 0){
            System.out.println("Não há pedidos!");
            return;
        }

        int option = 0;

        do{
            System.out.println(
                    "\nEscolha um Status de pedido." +
                    "\n1 - Pendente" +
                    "\n2 - Processando" +
                    "\n3 - Enviado" +
                    "\n4 - Entregue"
            );

            option = sc.nextInt();
        }while(option != 1 && option != 2 && option != 3 && option != 4);

        if(pedidoService.buscarPedidosPorStatus(status[option - 1]).isEmpty()){
            System.out.println("Não há pedidos com status: " + status[option - 1]);
        } else {
            pedidoService.buscarPedidosPorStatus(status[option - 1]).forEach(System.out::println);
        }
    }

    static void atualizarStatus(){
        System.out.println("Digite o número do pedido: ");
        int numero = sc.nextInt();
        int option;

        do{
            System.out.println(
                    "\nEscolha um novo Status para o pedido." +
                    "\n1 - Pendente" +
                    "\n2 - Processando" +
                    "\n3 - Enviado" +
                    "\n4 - Entregue"
            );

            option = sc.nextInt();
        }while(option != 1 && option != 2 && option != 3 && option != 4);

        pedidoService.atualizarStatusPedido(numero, status[option - 1]);
    }
}
