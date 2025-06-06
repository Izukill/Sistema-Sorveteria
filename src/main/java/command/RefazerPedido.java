package command;

import model.Pedido;
import state.PedidoCancelado;
import state.PedidoRecebido;

public class RefazerPedido implements Comando{

    private Pedido pedido;


    public RefazerPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        pedido.setEstado(new PedidoRecebido());
    }

    @Override
    public void desfazer() {
        pedido.setEstado(new PedidoCancelado());
    }
}
