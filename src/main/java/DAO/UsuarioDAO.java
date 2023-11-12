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
    private static final String INSERT_USUARIO = "INSERT INTO usuario(nome,sobrenome,usuario,senha,admin,idade,sexo) VALUES (?,?,?,?,?,?,?)";

    //Retorna uma lista com todos os usuarios, os dados passam pelo Model e são acessados através do objeto usuarios
    public static List<User> getAllUsuarios() {
        List<User> usuarios = new ArrayList();

        try (Connection connection = BancoDados.ConexaoDb();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User usuario = new User();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSobrenome(resultSet.getString("sobrenome"));
                usuario.setUsuario(resultSet.getString("usuario"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setIdade(resultSet.getInt("idade"));
                usuario.setSexo(resultSet.getString("sexo"));
                usuario.setAdmin(resultSet.getBoolean("admin"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    //Cria um usuario, as informações obrigatórias são passadas por parâmetro
    public static int criarUsuario(User usuario){
        int resultado = 0;

        try (Connection connection = BancoDados.ConexaoDb();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIO)) {

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(3, usuario.getUsuario());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setBoolean(5, false);
            preparedStatement.setInt(6, usuario.getIdade());
            preparedStatement.setString(7, usuario.getSexo());

            resultado = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(resultado == 1 ? "Query realizado com sucesso" : "Houve um erro ao realizar a query");
        return resultado;
    }

    public static User Login(String usuario, String senha) {
        User usuarioUser = null;

        try (Connection connection = BancoDados.ConexaoDb();
             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN)) {

            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User usuarioLogado = new User();
                    usuarioLogado.setId(resultSet.getInt("id"));
                    usuarioLogado.setNome(resultSet.getString("nome"));
                    usuarioLogado.setSobrenome(resultSet.getString("sobrenome"));
                    usuarioLogado.setUsuario(resultSet.getString("usuario"));
                    usuarioLogado.setSenha(resultSet.getString("senha"));
                    usuarioLogado.setIdade(resultSet.getInt("idade"));
                    usuarioLogado.setSexo(resultSet.getString("sexo"));
                    usuarioLogado.setAdmin(resultSet.getBoolean("admin"));

                    usuarioUser = usuarioLogado;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioUser;
    }
}
