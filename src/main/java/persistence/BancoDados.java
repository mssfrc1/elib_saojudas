package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {

    //Define ambiente de producao (1) ou teste (0) Aiven/psql Local
    private static int Producao = 1;

    public static Connection ConexaoDb() {
        
        //TESTE
        String usernameTeste = "postgres";
        String senhaTeste = "123456";
        String urlTeste = "jdbc:postgresql://localhost:5432/postgres";

        //PRODUCAO
        String usernameProducao = "avnadmin";
        String senhaProducao = "AVNS_V27U2dHnvZxXUrpgqEs";
        String urlProducao = "jdbc:postgresql://postgres-sql-elibrary-faculdade.a.aivencloud.com:15441/defaultdb?ssl=require";

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            //O getConnection fecha a conexão após as queries
            if (Producao == 1) {
                connection = DriverManager.getConnection(urlProducao, usernameProducao, senhaProducao);
            } else {
                connection = DriverManager.getConnection(urlTeste, usernameTeste, senhaTeste);
            }

            if (connection != null) {
                System.out.println("Conectado no banco de dados, retornando o objeto connection");
                return connection;
            } else {
                System.out.println("Falha na conexão");
            }
        } catch (SQLException e) {
            System.out.println("Falha na conexão, verificar log");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Falha ClassPath");
            e.printStackTrace();
        }
        return null;
    }
}
