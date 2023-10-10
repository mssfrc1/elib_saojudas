package controllers;

import java.util.List;

import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistence.BancoDados;

public class UserController {

    private static final String SELECT_ALL_USERS = "SELECT * FROM usuarios";
    private static final String SELECT_USER_SENHA = "SELECT usuario,senha FROM usuarios WHERE usuario = ? AND senha = ?";
    private static final String SELECT_USER_ADMIN = "SELECT usuario,admin FROM usuarios WHERE usuario = ?";
    private static final String INSERT_NEW_USER = "INSERT INTO usuarios(nome,sobrenome,usuario,senha,admin) VALUES (?,?,?,?,?)";
    static Connection connection = null;

    public static List<User> getAllUsers() {
        List<User> usuarios = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
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

    public static List<User> getUsuarioSenha(String usuario, String senha) {
        List<User> usuariosSenhaList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(SELECT_USER_SENHA);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User usuarioUser = new User();
                usuarioUser.setUsuario(resultSet.getString("usuario"));
                usuarioUser.setSenha(resultSet.getString("senha"));

                usuariosSenhaList.add(usuarioUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDados.fecharConexao(connection);
        }

        return usuariosSenhaList;
    }

    public static List<User> getAdmin(String usuario) {
        List<User> adminList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(SELECT_USER_ADMIN);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User usuarioUser = new User();
                usuarioUser.setUsuario(resultSet.getString("usuario"));
                usuarioUser.setAdmin(resultSet.getBoolean("admin"));

                adminList.add(usuarioUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDados.fecharConexao(connection);
        }

        return adminList;
    }

    public static int createUser(User user) {
        PreparedStatement preparedStatement = null;
        int resultado = 0;

        try {
            connection = BancoDados.ConexaoDb();

            preparedStatement = connection.prepareStatement(INSERT_NEW_USER);

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

    public static boolean login(String usuario, String senha) {
        boolean statusVerificacao = false;
        List<User> listaUsersSenhas = getUsuarioSenha(usuario, senha);
        Boolean verificacaoLista = listaUsersSenhas.stream()
                .map(n -> n.getUsuario() + " " + n.getSenha())
                .toList()
                .isEmpty();

        // Verificação de Usuario
        if (verificacaoLista == false) {
            statusVerificacao = true;
        }

        return statusVerificacao;
    }

    public static boolean verificacaoUsuarioAdmin(String usuario) {
        List<User> listaUserAdmin = getAdmin(usuario);
        Boolean verificacaoLista = listaUserAdmin.stream()
                .map(n -> n.getAdmin())
                .toList()
                .contains(true);

        return verificacaoLista;
    }

    public static void criarUsuario(User user) {
        createUser(user);
    }
}