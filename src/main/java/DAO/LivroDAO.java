package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Livro;
import persistence.BancoDados;

public class LivroDAO {

    //private static final String SELECT_ALL_LIVROS = "SELECT * FROM livro";
    private static final String INSERT_LIVRO = "INSERT INTO livro(nome, sinopse, id_genero, autor) VALUES (?,?,?,?)";
    private static final String SELECT_ALL_LIVROS = "SELECT " +
        "liv.id, " +
        "liv.nome, " +
        "liv.sinopse, " +
        "liv.capa, " +
        "liv.arquivo_livro, " +
        "liv.id_genero, " +
        "SUM(ava.nota) AS soma_avaliacao, " +
        "COUNT(ava.id_livro) AS count_livro, " +
        "ROUND(SUM(ava.nota) / CAST(COUNT(ava.id_livro) AS DECIMAL)) AS media_avaliacao, " +
        "gen.nome_genero " +
        "FROM livro AS liv " +
        "JOIN genero AS gen ON gen.id = liv.id_genero " +
        "JOIN avaliacao AS ava ON ava.id_livro = liv.id " +
        "GROUP BY liv.id, liv.nome, gen.nome_genero;";

    // Recebe todos os livros do banco de dados, a query passada é através da:
    // private static final String SELECT_ALL_LIVROS
    public static List<Livro> getAllLivros() {
        List<Livro> livros = new ArrayList<>();
    
        try (Connection connection = BancoDados.ConexaoDb();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LIVROS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
    
            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getInt("id"));
                livro.setNome(resultSet.getString("nome"));
                livro.setSinopse(resultSet.getString("sinopse"));
                livro.setCapa(resultSet.getString("capa"));
                livro.setArquivo_livro(resultSet.getString("arquivo_livro"));
                livro.setId_genero(resultSet.getInt("id_genero"));
                
                livro.setMedia(resultSet.getInt("media_avaliacao"));
                livro.setGenero(resultSet.getString("nome_genero"));

                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return livros;
    }
             
    //Insere os livros pedindo os campos como parâmetros obrigatorios
    public static int criarLivro(Livro livro) {
        int resultado = 0;
        try (Connection connection = BancoDados.ConexaoDb();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIVRO)) {
            preparedStatement.setString(1, livro.getNome());
            preparedStatement.setString(2, livro.getSinopse());
            preparedStatement.setInt(3, livro.getId_genero());
            preparedStatement.setString(4, livro.getAutor());

            resultado = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(resultado == 1 ? "Query realizada com sucesso" : "Houve um erro ao realizar a query");
        return resultado;
    }

}