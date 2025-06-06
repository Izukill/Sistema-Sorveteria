package repository;

import model.Cliente;

import java.sql.*;

public class ClienteBd implements ClienteRepository {

    //String com direção ao repositório
    private static final String bd= "jdbc:sqlite:Sorveteria.db";


    @Override
    public long adicionarCliente(Cliente cliente) {

        String sql = "INSERT INTO Cliente(Nome) VALUES(?)";
        long idGerado=-1; //Inicia com -1 para checagem de erro


        try (Connection conn = DriverManager.getConnection(bd);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {



            pstmt.setString(1, cliente.getNome());


            int ColunasCarregadas = pstmt.executeUpdate();

            if (ColunasCarregadas > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getLong(1);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente: " + e.getMessage());
        }


        cliente.setId((int)idGerado);

        return idGerado;
    }

    @Override
    public void lerCliente() {


    }
}
