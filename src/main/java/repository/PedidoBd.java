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

            int affectedRows = stmt.executeUpdate();


            //Atribiu id ao pedido dentro da classe
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        pedido.setId(generatedKeys.getLong(1));
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void atualizarPedido(Pedido pedido){

        String sql = "UPDATE Pedido SET descricao = ?, preco = ?, estado = ? WHERE id = ?";


        if (pedido.getId() == 0) {
            System.out.println("Erro, pedido sem id");
            return;
        }

        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, pedido.getDescricao());
            stmt.setDouble(2, pedido.getPreco());
            stmt.setString(3, pedido.getEstado().getNome());
            stmt.setLong(4, pedido.getId());


            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Pedido " + pedido.getId() + " atualizado com sucesso para o estado: " + pedido.getEstado().getNome());
            } else {
                System.out.println("Nenhum pedido encontrado com o ID: " + pedido.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


}
