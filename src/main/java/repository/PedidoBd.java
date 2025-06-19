package repository;


import model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoBd implements PedidoRepository {


    //String com direção ao repositório
    private static final String bd= "jdbc:sqlite:Sorveteria.db";


    @Override
    public void adicionarPedido(Pedido pedido) {

        String sql = "INSERT INTO Pedido (cliente_id, descricao, preco, estado) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pedido.getCliente().getId());
            stmt.setString(2, pedido.getProduto().getDescricao());
            stmt.setDouble(3, pedido.getProduto().getPreco());
            stmt.setString(4, pedido.getEstado().getNome());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Pedido> lerPedidos() {
        return null;
    }
}
