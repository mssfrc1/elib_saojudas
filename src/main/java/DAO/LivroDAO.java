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

    private static final String SELECT_ALL_LIVROS = "SELECT * FROM livro";
    private static final String INSERT_LIVRO = "INSERT INTO livro(nome, sinopse, id_genero, autor) VALUES (?,?,?,?)";
    private static final String GET_GENERO_BY_LIVRO_ID = "SELECT livro.*, g.* FROM livro INNER JOIN genero AS g ON livro.id_genero = g.id WHERE livro.id = ?";
    private static final String GET_MEDIA_BY_LIVRO_ID = "SELECT " +
        "liv.nome, " +
        "SUM(av.nota) AS soma_avaliacao, " +
        "COUNT(av.id_livro) AS count_livro, " +
        "SUM(av.nota) / COUNT(av.id_livro) AS media_avaliacao " +
        "FROM public.avaliacao AS av " +
        "INNER JOIN (SELECT id, nome FROM livro) AS liv ON liv.id = av.id_livro " +
        "WHERE liv.id = ? " +
        "GROUP BY av.id_usuario, av.id_livro, liv.nome;";

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
                
                livro.setMedia(getMediaByLivroId(resultSet.getInt("id")));
                livro.setGenero(getGeneroByLivroId(connection, resultSet.getInt("id")));

                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return livros;
    }
    
    public static String getGeneroByLivroId(Connection connection, int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String genero = null;
    
        try {
            preparedStatement = connection.prepareStatement(GET_GENERO_BY_LIVRO_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                genero = resultSet.getString("nome_genero");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return genero;
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


    //Realiza o cáculo de média de cada livro, baseado no id
    //sum media / count media.
    public static int getMediaByLivroId(int livroId) {
        int media = 0;
        try (Connection connection = BancoDados.ConexaoDb();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MEDIA_BY_LIVRO_ID)) {
            preparedStatement.setInt(1, livroId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                media = resultSet.getInt("media_avaliacao");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return media;
    }


}