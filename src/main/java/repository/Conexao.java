package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private final static String URL = "jdbc:sqlite:C:/Users/Aluno/Desktop/aula/Sistema-Sorveteria/src/main/java/repository/sorveteria.db";

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver SQLite não encontrado.", e);
        }
    }


}
