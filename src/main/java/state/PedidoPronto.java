package state;

import model.Pedido;

public class PedidoPronto implements EstadoPedido{
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoEntrege());
    }

    @Override
    public String getNome() {
        return " Pronto :D";
    }
}
