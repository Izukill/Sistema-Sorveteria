package command;

import model.Pedido;
import singleton.Fila;
import state.PedidoCancelado;
import state.PedidoRecebido;

public class RefazerPedido implements Comando {

    private Pedido pedido;
    private Fila fila= Fila.getInstancia();


    public RefazerPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {

        fila.add(pedido);
        pedido.setEstado(new PedidoRecebido());
    }

    @Override
    public void desfazer() {

        fila.remover(pedido);
        pedido.setEstado(new PedidoCancelado());
    }
}
