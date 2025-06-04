package state;

import model.Pedido;

public class PedidoRecebido implements EstadoPedido {
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoPreparando());

    }

    @Override
    public String getNome() {
        return "Pedido recebido :)";
    }
}
