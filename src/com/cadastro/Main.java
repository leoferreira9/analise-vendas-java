package com.cadastro;

import com.cadastro.model.Cliente;
import com.cadastro.model.Pedido;
import com.cadastro.model.StatusPedido;
import com.cadastro.service.ClienteService;
import com.cadastro.service.PedidoService;

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

            String entrada = sc.nextLine();

            if(entrada.matches("\\d+")){
                option = Integer.parseInt(entrada);

                switch (option){
                    case 1:
                        criarCliente();
                        break;
                    case 2:
                        novoPedido();
                        break;
                    case 3:
                        if(clienteService.listarClientes().isEmpty()){
                            System.out.println("\n❌ Não há clientes cadastrados");
                        } else {
                            clienteService.listarClientes().forEach(System.out::println);
                        }
                        break;
                    case 4:
                        if(pedidoService.listarPedidos().isEmpty()){
                            System.out.println("\n❌ Não há pedidos!");
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
                        System.out.println("\nEncerrando...");
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                }
            } else {
                System.out.println("\n⚠ Entrada inválida. Digite um número.");
                option = -1;
            }

        } while(option != 7);
    }


    static void criarCliente(){

        String nome;
        String cpf;
        String email;

        do{
            System.out.print("Digite seu nome: ");
            sc.nextLine();
             nome = sc.nextLine();
        }while(nome.isEmpty());

        do{
            System.out.print("Digite seu CPF: ");
            cpf = sc.nextLine();
        }while(cpf.isEmpty());

        do{
            System.out.print("Digite seu Email: ");
            email = sc.nextLine();
        }while(email.isEmpty());

        int id = clienteService.gerarNovoId();

        clienteService.adicionarCliente(new Cliente(nome, cpf, id, email));
    }

    static void novoPedido(){
        int id = 0;

        do{
            System.out.print("Informe o ID do cliente dono do pedido: ");
            id = sc.nextInt();
        } while(id == 0);

        Cliente c = clienteService.buscarClientePorId(id);

        if(c == null){
            System.out.println("\n❌ Cliente não encontrado com ID: " + id);
            return;
        }

        int numero = pedidoService.gerarNovoNumeroPedido();

        pedidoService.adicionarPedido(new Pedido(numero, c, StatusPedido.PENDENTE));
        System.out.println("\n✅ Pedido número (" + numero + ") criado com sucesso!");
    }

    static void buscarPedido(){

        if(pedidoService.listarPedidos().isEmpty()){
            System.out.println("\n❌ Não há pedidos!");
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
            System.out.println("\n❌ Não há pedidos com status: " + status[option - 1]);
        } else {
            pedidoService.buscarPedidosPorStatus(status[option - 1]).forEach(System.out::println);
        }
    }

    static void atualizarStatus(){

        if(pedidoService.listarPedidos().isEmpty()){
            System.out.println("\n❌ Não há pedidos");
            return;
        }

        System.out.print("Digite o número do pedido: ");
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
