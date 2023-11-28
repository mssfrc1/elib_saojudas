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

<<<<<<< HEAD
    private static final String SELECT_ALL_LIVROS = "SELECT * FROM livro";
    private static final String INSERT_LIVRO = "INSERT INTO livro (nome, sinopse, id_genero, capa, arquivo_livro) VALUES (?,?,?,?,?)";
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
=======
    // private static final String SELECT_ALL_LIVROS = "SELECT * FROM livro";
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
            "GROUP BY liv.id, liv.nome, gen.nome_genero " +
            "ORDER BY media_avaliacao DESC;";

    private static final String GET_LAST_LIVRO_ID = "SELECT id FROM livro ORDER BY id DESC LIMIT 1";
    private static final String GET_LIVRO_BY_NAME = "SELECT " +
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
            "WHERE liv.nome = ? " +
            "GROUP BY liv.id, liv.nome, gen.nome_genero ";
>>>>>>> origin/teste

    // Recebe todos os livros do banco de dados, a query passada é através da:
    // private static final String SELECT_ALL_LIVROS
    public static List<Livro> getAllLivros() {
        List<Livro> livros = new ArrayList<>();
<<<<<<< HEAD
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
    
        try {
            connection = BancoDados.ConexaoDb();
            preparedStatement = connection.prepareStatement(SELECT_ALL_LIVROS);
            resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                Livro livro = new Livro(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("sinopse"),
                    resultSet.getString("capa"),
                    resultSet.getString("arquivo_livro"),
                    resultSet.getString("id_genero")
                );
    
                livro.setGenero(getGeneroByLivroId(connection, resultSet.getInt("id")));
                livro.setMedia(10);
                
=======

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

>>>>>>> origin/teste
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
<<<<<<< HEAD
        } finally {
            BancoDados.fecharConexao(connection);
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
=======
        }

        return livros;
    }

    // Insere os livros pedindo os campos como parâmetros obrigatorios
    public static int criarLivro(String nome, String sinopse, int id_genero, String autor) {
        int resultado = 0;
        try (Connection connection = BancoDados.ConexaoDb();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIVRO)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, sinopse);
            preparedStatement.setInt(3, id_genero);
            preparedStatement.setString(4, autor);

            resultado = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(resultado == 1 ? "Query realizada com sucesso" : "Houve um erro ao realizar a query");
        return resultado;
    }

    public static int getLastLivroId() {
        int lastLivroId = -1;

        try (Connection connection = BancoDados.ConexaoDb();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_LAST_LIVRO_ID);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                lastLivroId = resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastLivroId;
    }

    public static Livro getLivroByNome(String nomeLivro) {
        Livro livro = null;
    
        try (Connection connection = BancoDados.ConexaoDb();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_LIVRO_BY_NAME)) {
            preparedStatement.setString(1, nomeLivro);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    livro = new Livro();
                    livro.setId(resultSet.getInt("id"));
                    livro.setNome(resultSet.getString("nome"));
                    livro.setSinopse(resultSet.getString("sinopse"));
                    livro.setCapa(resultSet.getString("capa"));
                    livro.setArquivo_livro(resultSet.getString("arquivo_livro"));
                    livro.setId_genero(resultSet.getInt("id_genero"));
    
                    livro.setMedia(resultSet.getInt("media_avaliacao"));
                    livro.setGenero(resultSet.getString("nome_genero"));
                }
>>>>>>> origin/teste
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
<<<<<<< HEAD
        return genero;
    }
    

    public static int criarLivro(Livro livro) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int resultado = 0;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(INSERT_LIVRO);

            preparedStatement.setString(1, livro.getNome());
            preparedStatement.setString(2, livro.getSinopse());
            preparedStatement.setString(3, livro.getCapa());
            //preparedStatement.setString(3, livro.getCap());
            preparedStatement.setString(5, livro.getArquivo_livro());
            preparedStatement.setBoolean(5, false);

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

=======
        return livro;
    }
    
>>>>>>> origin/teste
}