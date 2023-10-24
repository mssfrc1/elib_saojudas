package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {

    public static Connection ConexaoDb() {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String senha = "123456";

            connection = DriverManager.getConnection(url, username, senha);

            if (connection != null) {
                System.out.println("Conectado no banco de dados, retornando o objeto connection");
                return connection;
            } else {
                System.out.println("Falha na conexão");
            }

        } catch (SQLException e) {
            System.out.println("Falha na conexão, verificar log");
            e.printStackTrace();
        }

        return null;
    }

    public static void fecharConexao(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
            }
        }
    }
}
