package state;

import model.Pedido;

public class PedidoEntrege implements EstadoPedido{
    @Override
    public void proximoEstado(Pedido pedido) {
        System.out.println("Pedido já foi entregue :/");
    }


    @Override
    public String getNome() {
        return " Entregue ;)";
    }
}
