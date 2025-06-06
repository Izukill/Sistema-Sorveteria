package command;

import model.Pedido;
import state.EstadoPedido;
import state.PedidoCancelado;

public class CancelarPedido implements Comando{

    private Pedido pedido;
    private EstadoPedido estadoAnterior;

    public CancelarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        estadoAnterior= pedido.getEstado();

        System.out.println("Pedido Cancelado");
        pedido.setEstado(new PedidoCancelado());
    }

    @Override
    public void desfazer() {
        pedido.setEstado(estadoAnterior);

    }
}
