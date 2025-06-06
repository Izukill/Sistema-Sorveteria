package main;

import model.Cliente;
import model.Pedido;
import repository.ClienteBd;
import repository.PedidoBd;
import singleton.Fila;

public class Main {


    public static void main(String[] args) {
        Fila fila= Fila.getInstancia();


        PedidoBd repository=new PedidoBd();
        ClienteBd clienteRepository=new ClienteBd();




        Cliente cliente=new Cliente("BLABLABLA");
        Cliente cliente2=new Cliente("Luan fodao");
        Cliente cliente3=new Cliente("AAAAAAA");



        clienteRepository.adicionarCliente(cliente2);


        System.out.println("Cliente "+cliente2.getNome()+" salvo com sucesso; id: "+cliente2.getId());

        Pedido meupedido=new Pedido(cliente2,"Sorvete de Flocos",8.0f);
        repository.adicionarPedido(meupedido);

        System.out.println(repository.lerPedidos());











    }
}
