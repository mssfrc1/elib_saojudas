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
                User usuario = new User();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSobrenome(resultSet.getString("sobrenome"));
                usuario.setUsuario(resultSet.getString("usuario"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setAdmin(resultSet.getBoolean("admin"));

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

    /*
     * public static boolean verificacaoUsuarioAdmin(String usuario) {
     * List<User> listaUserAdmin = getAdmin(usuario);
     * Boolean verificacaoLista = listaUserAdmin.stream()
     * .map(n -> n.getAdmin())
     * .toList()
     * .contains(true);
     * 
     * return verificacaoLista;
     * }
     */

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
                User databaseUser = new User();
                databaseUser.setUsuario(resultSet.getString("usuario"));
                databaseUser.setSenha(resultSet.getString("senha"));
                databaseUser.setIdade(resultSet.getInt("idade"));
                databaseUser.setNome(resultSet.getString("nome"));
                databaseUser.setSobrenome(resultSet.getString("sobrenome"));
                databaseUser.setSexo(resultSet.getString("sexo"));
                databaseUser.setAdmin(resultSet.getBoolean("admin"));

                System.out.println(databaseUser);
                usuarioUser = databaseUser;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDados.fecharConexao(connection);
        }
        System.out.println();
        return usuarioUser;
    }
}
