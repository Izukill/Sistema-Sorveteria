package command;

import model.Pedido;
import state.PedidoCancelado;
import state.PedidoRecebido;

public class FazerPedido implements Comando{

    private Pedido pedido;


    public FazerPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {

        System.out.println("Pedido realizado");
        pedido.setEstado(new PedidoRecebido());
        //TODO adicionar metodo de criação
    }

    @Override
    public void desfazer() {
        System.out.println("Pedido Cancelado");
        pedido.setEstado(new PedidoCancelado());
    }
}
