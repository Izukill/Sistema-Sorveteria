package command;

import decorator.PedidoBase; // eu add
import singleton.Fila;// eu add
import model.Pedido;
import state.PedidoCancelado;

public class FazerPedido implements Comando {

    private PedidoBase pedido;
    private Fila fila = Fila.getInstancia();

    public FazerPedido(PedidoBase pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        System.out.println("Pedido realizado: " + pedido.getDescricao() + " - R$ " + pedido.getPreco());
        // aqui eu add, um caso onde o pedido seja puro, ele passe direto
        if (pedido instanceof Pedido) {
            fila.add((Pedido) pedido);
        } else {
            System.out.println("Atenção: Pedido decorado não é instância direta de Pedido. Considere adaptar a Fila.");
        }
    }

    @Override
    public void desfazer() {
        System.out.println("Desfazendo pedido: " + pedido.getDescricao());
        fila.remover(pedido);
        // aqui é caso queira alterar o estado
        if (pedido instanceof Pedido) {
            ((Pedido) pedido).setEstado(new PedidoCancelado());
        }
    }
}


