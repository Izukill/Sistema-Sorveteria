package repository;


import factory.Gelados;
import model.Cliente;
import model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoBd implements PedidoRepository {


    //String com direção ao repositório
    private static final String bd= "jdbc:sqlite:Sorveteria.db";


    @Override
    public long adicionarPedido(Pedido pedido) {

        String sql = "INSERT INTO Pedidos(Descricao, Preco, ClienteId, Estado) VALUES(?, ?, ?, ?)";
        long idGerado=-1; //Inicia com -1 para checagem de erro


        try (Connection conn = DriverManager.getConnection(bd);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            //TODO fazer com que pedido estaja na tabela do bd
            //pstmt.setString(1, (String)pedido.getSorvete());
            pstmt.setFloat(2, pedido.getPreco());
            pstmt.setInt(3, pedido.getCliente().getId());

            int ColunasCarregadas = pstmt.executeUpdate();

            if (ColunasCarregadas > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getLong(1);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao inserir pedido: " + e.getMessage());
        }

        pedido.setId(idGerado);

        return idGerado;






    }

    @Override
    public List<Pedido> lerPedidos() {

        List<Pedido> pedidos = new ArrayList<>();


        String sql = "SELECT " +
                "  p.Id AS PedidoId, " +
                "  p.Descricao, " +
                "  p.Preco, " +
                "  c.Id AS ClienteId, " +
                "  c.Nome AS ClienteNome " +
                "FROM Pedidos AS p " +
                "INNER JOIN Cliente AS c ON p.ClienteId = c.Id";

        try (Connection conn = DriverManager.getConnection(bd);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {

//
//                // 1. Extrair os dados do cliente da linha atual
//                int clienteId = rs.getInt("ClienteId");
//                String clienteNome = rs.getString("ClienteNome");
//
//                // 2. Criar o objeto Cliente
//                Cliente cliente = new Cliente(clienteNome,clienteId);
//
//                // 3. Extrair os dados do pedido da linha atual
//                long pedidoId = rs.getLong("PedidoId");
//                String sorvete = rs.getString("Sorvete");
//                float preco = rs.getFloat("Preco");
//
//                // 4. Criar o objeto Pedido, usando o objeto Cliente criado acima
//                Pedido pedido = new Pedido(cliente, , preco);
//                pedido.setId(pedidoId);
//                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao ler pedidos: " + e.getMessage());
        }


        return pedidos;

    }
}
