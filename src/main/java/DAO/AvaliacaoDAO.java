package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> origin/teste

import persistence.BancoDados;

public class AvaliacaoDAO {
<<<<<<< HEAD
    private static final String INSERT_AVALIACAO_BY_USUARIO_ID = "INSERT INTO avaliacao (id_usuario,id_livro,data_inicio,nota) VALUES (?,?,?,?);";
    static Connection connection = null;

    public static int insertAvaliacaoByUsuarioId(int id_usuario, int id_livro, int avaliacao) {
        PreparedStatement preparedStatement = null;
        int resultado = 0;
        var Date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(Date.getTime());

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(INSERT_AVALIACAO_BY_USUARIO_ID);

            preparedStatement.setInt(1, id_usuario);
            preparedStatement.setInt(2, id_livro);
            preparedStatement.setDate(3,sqlDate);
            preparedStatement.setInt(4, avaliacao);

            resultado = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getSQLState();
        } finally {
            BancoDados.fecharConexao(connection);
        }

        if (resultado == 0) {
            System.out.print("Houve um erro ao executar a query");
            return resultado;
        } else {
            System.out.println("A query foi realiza com êxito");
            return resultado;
        }
    }
}
=======

    //Insere uma avaliação, os dados obrigatórios são passados por parâmetro
    private static final String INSERT_AVALIACAO = "INSERT INTO avaliacao (id_usuario, id_livro, data_inicio, nota) VALUES (?, ?, ?, ?)";

        public static int insertAvaliacao(int id_usuario, int id_livro, int avaliacao) {
        int resultado = 0;

        try (Connection connection = BancoDados.ConexaoDb();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AVALIACAO)) {

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            preparedStatement.setInt(1, id_usuario);
            preparedStatement.setInt(2, id_livro);
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setInt(4, avaliacao);

            resultado = preparedStatement.executeUpdate();

            if (resultado == 0) {
                System.out.println("Erro ao criar avaliação");
            } else {
                System.out.println("Avaliação inserida com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
>>>>>>> origin/teste
