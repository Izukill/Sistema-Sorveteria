package facade;

import command.*;
import decorator.Chantilly;
import decorator.Cobertura;
import decorator.Granulado;
import decorator.PedidoBase;
import factory.SorveteriaFactory;
import model.Cliente;
import model.Pedido;
import repository.ClienteBd;
import repository.PedidoBd;
import singleton.Fila;
import state.PedidoEntrege;

public class SorveteriaFacade {

    private ComandoInvoker comandoInvoker=new ComandoInvoker();

    private Fila fila= Fila.getInstancia();

    private PedidoBd pedidoRepository=new PedidoBd();
    private ClienteBd clienteRepository= new ClienteBd();


    public void desfazerComando(){
        comandoInvoker.desfazer();
    }

    public void fazerPedido(Cliente cliente, SorveteriaFactory fabrica){

        PedidoBase base= fabrica.criarGelado();
        //TODO adicionar decorator caso tenha

        Pedido pedido=new Pedido(cliente,base);
        pedido.adicionarClienteObserver();



        Comando comando=new FazerPedido(pedido);
        comandoInvoker.executar(comando);

        pedidoRepository.adicionarPedido(pedido);
        clienteRepository.adicionarCliente(cliente);


    }




    public void avancarEstado(Pedido pedido){

        Comando comando=new AvancaEstado(pedido);
        comandoInvoker.executar(comando);

        if(pedido.getEstado() instanceof PedidoEntrege){
            fila.remover(pedido);
        }

    }

    public void cancelarPedido(Pedido pedido){

        Comando comando=new CancelarPedido(pedido);
        comandoInvoker.executar(comando);
    }

    public void refazerPedido(Pedido pedido){

        Comando comando=new RefazerPedido(pedido);
        pedido.adicionarClienteObserver();
        comandoInvoker.executar(comando);
    }


    public void adicionarCobertura(Pedido pedido){

        PedidoBase decorator= new Cobertura(pedido.getProduto());
        pedido.setProduto(decorator);

    }

    public void adicionarGranulado(Pedido pedido){

        PedidoBase decorator= new Granulado(pedido.getProduto());
        pedido.setProduto(decorator);

    }


    public void adicionarChantilly(Pedido pedido){

        PedidoBase decorator= new Chantilly(pedido.getProduto());
        pedido.setProduto(decorator);

    }



    public void mostrarFila(){
        System.out.println(fila.toString());
    }




}
