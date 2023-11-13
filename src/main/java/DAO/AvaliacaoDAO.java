package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import persistence.BancoDados;


public class AvaliacaoDAO {

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

