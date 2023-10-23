package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Livro;
import models.User;
import persistence.BancoDados;

public class LivroDAO {

    private static final String SELECT_ALL_LIVROS = "SELECT * FROM livro";
    private static final String INSERT_LIVRO = "INSERT INTO livro(nome, sinopse, id_genero, capa, arquivo_livro) VALUES (?,?,?,?,?)";
    private static final String GET_GENERO_BY_LIVRO_ID = "SELECT livro.*, g.* FROM livro INNER JOIN genero AS g ON livro.id_genero = g.id WHERE livro.id = ?";
    static Connection connection = null;

    // Recebe todos os livros do banco de dados, a query passada é através da:
    // private static final String SELECT_ALL_LIVROS
    public static List<Livro> getAllLivros() {
        List<Livro> livros = new ArrayList<>();
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
    
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return genero;
    }
    

    public static int criarLivro(Livro livro) {
        PreparedStatement preparedStatement = null;
        int resultado = 0;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(INSERT_LIVRO);

            preparedStatement.setString(1, livro.getNome());
            preparedStatement.setString(2, livro.getSinopse());
            preparedStatement.setString(3, livro.getCapa());
            preparedStatement.setString(3, livro.getCap());
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

}