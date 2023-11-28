package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import models.User;
import persistence.BancoDados;

public class UsuarioDAO {
    private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario";
    private static final String LOGIN = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
    private static final String SELECT_USER_ADMIN = "SELECT usuario,admin FROM usuario WHERE usuario = ?";
    private static final String INSERT_USUARIO = "INSERT INTO usuario (nome,sobrenome,usuario,senha,admin) VALUES (?,?,?,?,?)";
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
=======
import javax.print.DocFlavor.STRING;

import models.User;
import persistence.BancoDados;

    public class UsuarioDAO { 
    private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario;";
    private static final String GET_USUARIO_FAVORITO =
    "SELECT u.*, gen.nome_genero AS genero_favorito " +
    "FROM usuario AS u " +
    "JOIN favorito AS fav ON fav.id_usuario = u.id " +
    "JOIN genero AS gen ON gen.id = fav.id_genero " + 
    "WHERE u.id = ?";
    private static final String SELECT_USUARIO_BY_NAME = "SELECT * FROM usuario WHERE NOME = ?";
    private static final String LOGIN = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
    private static final String INSERT_USUARIO = "INSERT INTO usuario(nome,sobrenome,usuario,senha,admin,idade,sexo) VALUES (?,?,?,?,?,?,?)";
    private static final String GET_LAST_USUARIO_ID = "SELECT id FROM usuario ORDER BY id DESC LIMIT 1";
    private static final String UPDATE_USUARIO = "UPDATE INTO usuario SET nome = ? , sobrenome = ? , usuario = ? , senha = ? , idade = ? , sexo = ? WHERE id = ?";

    // Retorna uma lista com todos os usuarios, os dados passam pelo Model e são
    // acessados através do objeto usuarios
    public static List<User> getAllUsuarios() {
        List<User> usuarios = new ArrayList();
        String genero = "";

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
                usuario.setGeneroFav(getUsuariosFavoritos(resultSet.getInt("id")));
>>>>>>> origin/teste

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
<<<<<<< HEAD
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
=======
        }
        System.out.println(genero);
        return usuarios;
    }

    public static String getUsuariosFavoritos(int id) {
        var genero = "";

        try (Connection connection = BancoDados.ConexaoDb();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_USUARIO_FAVORITO)) {
            preparedStatement.setInt(1, id);  // Corrected this line to set the integer parameter

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    genero = genero + ", " + resultSet.getString("genero_favorito");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genero.replaceFirst(", ", "");
    }


    // Cria um usuario, as informações obrigatórias são passadas por parâmetro
    public static int criarUsuario(User usuario) {
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
>>>>>>> origin/teste

            resultado = preparedStatement.executeUpdate();

        } catch (SQLException e) {
<<<<<<< HEAD
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
=======
            e.printStackTrace();
        }
        System.out.println(resultado == 1 ? "Query realizado com sucesso" : "Houve um erro ao realizar a query");
        return resultado;
>>>>>>> origin/teste
    }

    public static User Login(String usuario, String senha) {
        User usuarioUser = null;
<<<<<<< HEAD
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

    public static boolean verificacaoUsuarioAdmin(String usuario) {
        List<User> listaUserAdmin = getAdmin(usuario);
        Boolean verificacaoLista = listaUserAdmin.stream()
                .map(n -> n.getAdmin())
                .toList()
                .contains(true);

        return verificacaoLista;
=======

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

    public static int getLastUsuarioId() {
        int lastUsuarioId = -1;

        try (Connection connection = BancoDados.ConexaoDb();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_LAST_USUARIO_ID);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                lastUsuarioId = resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastUsuarioId;
    }

    public static User getUsuarioByNome(String nomeUsuario) {
        User user = null;
    
        try (Connection connection = BancoDados.ConexaoDb();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIO_BY_NAME)) {
            preparedStatement.setString(1, nomeUsuario);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setNome(resultSet.getString("nome"));
                    user.setSobrenome(resultSet.getString("sobrenome"));
                    user.setUsuario(resultSet.getString("usuario"));
                    user.setSenha(resultSet.getString("senha"));
                    user.setIdade(resultSet.getInt("idade"));
                    user.setSexo(resultSet.getString("sexo"));
                    user.setGeneroFav(getUsuariosFavoritos(resultSet.getInt("id")));
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return user;
>>>>>>> origin/teste
    }
}
