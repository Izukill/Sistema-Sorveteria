package facade;

import command.*;
import factory.Gelados;
import factory.SorveteriaFactory;
import model.Cliente;
import model.Pedido;
import repository.PedidoBd;
import singleton.Fila;
import state.PedidoEntrege;
import state.PedidoPronto;

public class SorveteriaFacade {

    private ComandoInvoker comandoInvoker=new ComandoInvoker();

    private Fila fila= Fila.getInstancia();

    private PedidoBd pedidoRepository=new PedidoBd();


    public void desfazerComando(){
        comandoInvoker.desfazer();
    }

    public void fazerPedido(Cliente cliente, SorveteriaFactory fabrica){

        Gelados gelado= fabrica.criarGelado();
        //TODO adicionar decorator caso tenha

        Pedido pedido=new Pedido(cliente,gelado);
        pedido.adicionarClienteObserver();



        Comando comando=new FazerPedido(pedido);
        comandoInvoker.executar(comando);

        //pedidoRepository.adicionarPedido(pedido);

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



    public void mostrarFila(){
        System.out.println(fila.toString());
    }




}
