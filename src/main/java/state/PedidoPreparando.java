package state;

import model.Pedido;

public class PedidoPreparando implements EstadoPedido{
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoPronto());
    }

    @Override
    public String getNome() {
        return "Pedido preparando ;/";
    }
}
