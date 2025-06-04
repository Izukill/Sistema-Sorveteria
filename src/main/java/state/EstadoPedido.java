package state;

import model.Pedido;

public interface EstadoPedido {
    void proximoEstado(Pedido pedido);
    String getNome();


}
