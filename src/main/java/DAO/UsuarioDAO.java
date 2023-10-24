package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;
import persistence.BancoDados;

public class UsuarioDAO {
    private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario";
    private static final String LOGIN = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
    private static final String INSERT_USUARIO = "INSERT INTO usuario(nome,sobrenome,usuario,senha,admin) VALUES (?,?,?,?,?)";
    static Connection connection = null;

    public static List<User> getAllUsuarios() {
        List<User> usuarios = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User usuario = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("sobrenome"),
                    resultSet.getString("usuario"),
                    resultSet.getString("senha"),
                    resultSet.getInt("idade"),
                    resultSet.getString("sexo"),
                    resultSet.getBoolean("admin")
                );

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDados.fecharConexao(connection);
        }

        return usuarios;
    }

    public static int criarUsuario(User user) {
        PreparedStatement preparedStatement = null;
        int resultado = 0;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(INSERT_USUARIO);

            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getSobrenome());
            preparedStatement.setString(3, user.getUsuario());
            preparedStatement.setString(4, user.getSenha());
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

    public static User Login(String usuario, String senha) {
        User usuarioUser = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               User usuarioLogado = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("sobrenome"),
                    resultSet.getString("usuario"),
                    resultSet.getString("senha"),
                    resultSet.getInt("idade"),
                    resultSet.getString("sexo"),
                    resultSet.getBoolean("admin")
                );

                usuarioUser = usuarioLogado;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDados.fecharConexao(connection);
        }
        return usuarioUser;
    }
}
