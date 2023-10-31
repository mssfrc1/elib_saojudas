package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import persistence.BancoDados;

public class AvaliacaoDAO {
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
