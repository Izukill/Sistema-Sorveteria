package repository;

import model.Pedido;

import java.util.List;

public interface PedidoRepository {
    void adicionarPedido(Pedido pedido);
    void atualizarPedido(Pedido pedido);
}
