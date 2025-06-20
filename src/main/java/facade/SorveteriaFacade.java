package facade;

import command.*;
import decorator.PedidoBase;
import factory.SorveteriaFactory;
import model.Cliente;
import model.Pedido;
import singleton.Fila;
import state.PedidoEntrege;

public class SorveteriaFacade {

    private ComandoInvoker comandoInvoker=new ComandoInvoker();

    private Fila fila= Fila.getInstancia();


    public void desfazerComando(){
        comandoInvoker.desfazer();

    }

    public void fazerPedido(Cliente cliente, SorveteriaFactory fabrica){

        PedidoBase base= fabrica.criarGelado();


        Pedido pedido=new Pedido(cliente,base);
        pedido.adicionarClienteObserver();

        Comando comando=new FazerPedido(pedido);
        comandoInvoker.executar(comando);



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



    public void AdicionarDecorator(Pedido pedido, String personalizacao){

        Comando comando=new AdicionarPersonalizacao(pedido, personalizacao);
        comandoInvoker.executar(comando);

    }



    public void mostrarFila(){
        System.out.println(fila.toString());
    }




}
