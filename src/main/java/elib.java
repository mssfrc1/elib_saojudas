import java.util.Arrays;
import java.util.List;

import controllers.*;
import DAOs.UserDAO;
import models.Livro;
import models.User;
import views.TelaLogin;

public class elib {
    public static void main(String[] args) {
        // Chamando o metodo do LivroController
        //getAllLivros();
        //getLivroById(3);              
        //getLivroByGenero("Didatico");   
        //getLivroByNome("Duna");         
        //getAllUsers();
        //login("rbossini","teste");
        //getAdmin("admin");         
        //criarUsuario(new User("Rodrig","Bossii","rbossini","teste")); 
        telaLogin();
    }

    public static void getAllLivros() {
        Livro[] livros = LivroController.getAllLivros();
        System.out.println(Arrays.toString(livros));
    }

    public static void getLivroById(int idLivro) {
        Livro livro = LivroController.getLivroById(idLivro);

        System.out.println("Livro ID: " + livro.getId());
        System.out.println("Nome: " + livro.getNome());
        System.out.println("Sinopse: " + livro.getSinopse());
        System.out.println("Gênero: " + livro.getGenero());
        System.out.println("Capa: " + livro.getCapa());
        System.out.println("Arquivo do Livro: " + livro.getArquivo_livro());
    }

    public static void getLivroByGenero(String genero) {
        Livro[] livros = LivroController.getLivrosByGenero(genero);
        System.out.println(livros);
    }

    public static void getLivroByNome(String nome) {
        Livro[] livros = LivroController.getLivrosByNome(nome);
        System.out.println(livros);
    }

    public static void getAllUsers() {
        List<User> listUsers = UserDAO.getAllUsers();
        System.out.println(listUsers);
    }

    public static void login(String usuario, String senha) {
        boolean listUsuarios = UserController.login(usuario,senha);
        System.out.println(listUsuarios);
    }

    public static void getAdmin(String usuario) {
        boolean listAdmin = UserController.verificacaoUsuarioAdmin(usuario);
        System.out.println(listAdmin);
    }

    public static void criarUsuario(User user) {
        UserController.criarUsuario(user);
    }

     public static void telaLogin() {
        TelaLogin field = new TelaLogin();
        field.setVisible(true);
    }

}
