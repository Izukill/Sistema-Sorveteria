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



            int affectedRows = stmt.executeUpdate();

            //Atribui id ao cliente ao salvar no banco de dados (caso contrario todos ficam com id=0)
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cliente.setId(generatedKeys.getLong(1));
                    }
                }
            }


        } catch (SQLException e) {
            System.err.println("Erro ao adicionar cliente: " + e.getMessage());
            e.printStackTrace();
        }

    }


}
