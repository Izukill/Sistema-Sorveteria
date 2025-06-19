package main;


import facade.SorveteriaFacade;
import factory.*;
import model.Cliente;
import model.Pedido;
import repository.ClienteBd;
import repository.PedidoBd;
import singleton.Fila;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //Instancia da Fila


        //Instancias dos Factorys
        SorveteriaFactory picole = new PicoleFactory();
        SorveteriaFactory sorvete = new SorveteFactory();
        SorveteriaFactory milkshake = new MilkShakeFactory();


        //Instancia do Facade
        SorveteriaFacade facade = new SorveteriaFacade();


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
                    } else {
                        System.out.println("⚠️ Fila vazia!");
                    }
                    break;

                case 2:
                    if (!Fila.getInstancia().vazia()) {
                        Pedido pedidoAtual = Fila.getInstancia().primeiro();
                        facade.cancelarPedido(pedidoAtual);
                        System.out.println("❌ Pedido cancelado.");
                        ultimoPedido = pedidoAtual;
                    } else {
                        System.out.println("⚠️ Fila vazia!");
                    }
                    break;

                case 3:
                    if (ultimoPedido != null) {
                        facade.refazerPedido(ultimoPedido);
                        System.out.println("♻️ Pedido refeito.");
                    } else {
                        System.out.println("⚠️ Nenhum pedido foi cancelado ainda.");
                    }
                    break;

                case 4:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    Cliente cliente = new Cliente(nome);

                    System.out.println("Escolha o tipo de sorvete:");
                    System.out.println("1 - Picolé");
                    System.out.println("2 - Sorvete");
                    System.out.println("3 - Milkshake");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

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
                        Pedido pedidoCriado = Fila.getInstancia().ultimo();// pega o último pedido da fila
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
                                case 1 -> facade.adicionarChantilly(pedidoCriado);
                                case 2 -> facade.adicionarGranulado(pedidoCriado);
                                case 3 -> facade.adicionarCobertura(pedidoCriado);
                                case 4 -> {
                                    adicionando = false;
                                    System.out.println("🍨 Pedido finalizado com sucesso!");
                                }
                                default -> System.out.println("❌ Opção inválida.");
                            }
                        }
                    }
                    break;

                case 5:
                    facade.mostrarFila();
                    break;

                case 6:
                    executando = false;
                    System.out.println("👋 Encerrando sorveteria.");
                    break;

                default:
                    System.out.println("❌ Opção inválida.");
            }
        }

        scanner.close();
    }
}
