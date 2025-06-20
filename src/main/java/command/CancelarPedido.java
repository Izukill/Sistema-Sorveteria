package command;

import model.Pedido;
import singleton.Fila;
import state.EstadoPedido;
import state.PedidoCancelado;

public class CancelarPedido implements Comando {

    private Pedido pedido;
    private Fila fila=Fila.getInstancia();
    private EstadoPedido estadoAnterior;

    public CancelarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        estadoAnterior= pedido.getEstado();


        fila.remover(pedido);
        pedido.setEstado(new PedidoCancelado());
    }

    @Override
    public void desfazer() {

        fila.add(pedido);
        pedido.setEstado(estadoAnterior);

    }
}
