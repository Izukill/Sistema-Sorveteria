package repository;

import model.Cliente;

import java.sql.*;

public class ClienteBd implements ClienteRepository {



    @Override
    public void adicionarCliente(Cliente cliente) {

        String sql = "INSERT INTO Cliente (nome) VALUES (?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Erro ao adicionar cliente: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void lerCliente() {

    }
}
