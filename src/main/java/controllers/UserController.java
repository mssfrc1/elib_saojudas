package controllers;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> origin/teste
import DAO.UsuarioDAO;
import models.User;

public class UserController {
<<<<<<< HEAD

    public static boolean login(String usuario, String senha) {
        return UsuarioDAO.Login(usuario, senha) != null ? true : false; 
    }

    public static int criarUsuario(User user) {
        return UsuarioDAO.criarUsuario(user);
    }

    public static boolean verificacaoUsuarioAdmin(String usuario) {
        return UsuarioDAO.verificacaoUsuarioAdmin(usuario) == true ? true : false; 
=======
    
    public static User usuarioLogado;

    public static List<User> getAllUsuarios() {
        return UsuarioDAO.getAllUsuarios();
    }

    public static User login(String usuario, String senha) {
        var user = UsuarioDAO.Login(usuario, senha);
        if (user != null) {
            usuarioLogado = user;
        }
        return user;
    }

    public static int criarUsuario(User usuario) {
        if (usuario.getSexo() != null) {
            return UsuarioDAO.criarUsuario(new User(usuario.getNome(),usuario.getSobrenome(),usuario.getUsuario(),usuario.getSenha(),usuario.getIdade(),usuario.getSexo()));
        }
        return 0;
    }

    public static int getLastUsuarioId() {
       return UsuarioDAO.getLastUsuarioId();
>>>>>>> origin/teste
    }

    public static List<String> filterByName() {
        return getAllUsuarios().stream()
            .map(n -> n.getNome())
            .toList();
    }

    public static User getUsuarioByNome(String nomeUsuario) {
        return UsuarioDAO.getUsuarioByNome(nomeUsuario);
    }
}
