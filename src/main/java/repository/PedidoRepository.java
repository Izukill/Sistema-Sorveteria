package repository;

import model.Pedido;

import java.util.List;

public interface PedidoRepository {
    long adicionarPedido(Pedido pedido);
    List<Pedido> lerPedidos();
}
