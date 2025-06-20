package main;

import facade.SorveteriaFacade;
import facade.PagamentoFacade;
import factory.*;
import model.Cliente;
import model.Pedido;
import repository.ClienteBd;
import repository.PedidoBd;
import repository.Servico;
import singleton.Fila;
import strategy.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Instâncias dos Factories
        SorveteriaFactory picole = new PicoleFactory();
        SorveteriaFactory sorvete = new SorveteFactory();
        SorveteriaFactory milkshake = new MilkShakeFactory();

        // Instâncias dos Facades
        SorveteriaFacade facade = new SorveteriaFacade();

        // Instâncias dos Repositórios e Serviço
        PedidoBd pedidoBd = new PedidoBd();
        ClienteBd clienteBd = new ClienteBd();
        Servico servico = new Servico(pedidoBd, clienteBd);

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;
        Pedido ultimoPedido = null;

        while (executando) {

            System.out.println("\n=== Menu ===");
            System.out.println("1 - Avançar estado do próximo pedido");
            System.out.println("2 - Cancelar próximo pedido");
            System.out.println("3 - Refazer último pedido");
            System.out.println("4 - Fazer novo pedido");
            System.out.println("5 - Mostrar fila");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (!Fila.getInstancia().vazia()) {
                        Pedido pedidoAtual = Fila.getInstancia().primeiro();
                        facade.avancarEstado(pedidoAtual);
                        servico.atualizarPedido(pedidoAtual);
                    } else {
                        System.out.println("Fila vazia!");
                    }
                    break;

                case 2:
                    if (!Fila.getInstancia().vazia()) {
                        Pedido pedidoAtual = Fila.getInstancia().primeiro();
                        facade.cancelarPedido(pedidoAtual);
                        servico.atualizarPedido(pedidoAtual);
                        ultimoPedido = pedidoAtual;
                    } else {
                        System.out.println("Fila vazia!");
                    }
                    break;

                case 3:
                    if (ultimoPedido != null) {
                        facade.refazerPedido(ultimoPedido);
                        servico.atualizarPedido(ultimoPedido);
                        System.out.println("Pedido refeito.");
                    } else {
                        System.out.println("Nenhum pedido foi cancelado ainda.");
                    }
                    break;

                case 4:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    Cliente cliente = new Cliente(nome);
                    servico.salvarCliente(cliente);

                    System.out.println("Escolha o tipo de sorvete:");
                    System.out.println("1 - Picolé");
                    System.out.println("2 - Sorvete");
                    System.out.println("3 - Milkshake");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    SorveteriaFactory fabrica = switch (tipo) {
                        case 1 -> picole;
                        case 2 -> sorvete;
                        case 3 -> milkshake;
                        default -> {
                            System.out.println("Tipo inválido. Pedido cancelado.");
                            yield null;
                        }
                    };

                    if (fabrica != null) {
                        facade.fazerPedido(cliente, fabrica);
                        Pedido pedidoCriado = Fila.getInstancia().ultimo();
                        boolean adicionando = true;

                        while (adicionando) {
                            System.out.println("\nDeseja adicionar alguma cobertura?");
                            System.out.println("1 - Chantilly");
                            System.out.println("2 - Granulado");
                            System.out.println("3 - Cobertura");
                            System.out.println("4 - Finalizar pedido");
                            System.out.print("Escolha uma opção: ");
                            int escolha = scanner.nextInt();

                            switch (escolha) {
                                case 1 -> facade.AdicionarDecorator(pedidoCriado,"chantilly");
                                case 2 -> facade.AdicionarDecorator(pedidoCriado,"granulado");
                                case 3 -> facade.AdicionarDecorator(pedidoCriado,"cobertura");
                                case 4 -> {
                                    adicionando = false;
                                    System.out.println("Pedido finalizado com sucesso!");
                                }
                                default -> System.out.println("Opção inválida.");
                            }


                            }

                        System.out.println("\nEscolha o tipo de desconto:");
                        System.out.println("1 - Cliente frequente");
                        System.out.println("2 - Desconto sazonal");
                        System.out.println("3 - Sem desconto");
                        System.out.print("Opção: ");


                        PagamentoFacade pagamentoFacade = new PagamentoFacade(new SemDesconto());
                        int tipoDesconto = scanner.nextInt();

                        switch (tipoDesconto) {

                            case 1 -> pagamentoFacade.setStrategy(new DescontoClienteFrequente());
                            case 2 -> pagamentoFacade.setStrategy(new DescontoSazonal());
                            case 3 -> pagamentoFacade.setStrategy(new SemDesconto());
                            default -> {
                                System.out.println("Opção inválida. Sem desconto aplicado.");
                                pagamentoFacade.setStrategy(new SemDesconto());
                            }


                        }

                        float valorPedido= pagamentoFacade.pagamento(pedidoCriado);
                        pagamentoFacade.notaPagamento(pedidoCriado);

                        // Salvar pedido finalizado no banco de dados
                        servico.salvarPedido(pedidoCriado);
                    }
                    break;

                case 5:
                    facade.mostrarFila();
                    break;

                case 6:
                    executando = false;
                    System.out.println("Encerrando sorveteria.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
