package state;

import model.Pedido;

public class PedidoCancelado implements EstadoPedido{
    @Override
    public void proximoEstado(Pedido pedido) {
        System.out.println("O pedido foi cancelado.");
    }



    @Override
    public String getNome() {
        return " Cancelado :(";
    }
}
