import java.util.Arrays;

import controllers.*;
import models.User;
<<<<<<< HEAD
import views.TelaBiblioteca;
import views.TelaLogin;
=======
import views.livro.TelaBiblioteca;
import views.usuario.TelaLogin;
>>>>>>> origin/teste
import DAO.*;

public class elib {
    public static void main(String[] args) {
        // Chamando o metodo do LivroController
<<<<<<< HEAD
        //System.out.println(LivroController.getAllLivros());
=======
        System.out.println(LivroController.getAllLivros());
>>>>>>> origin/teste
        //System.out.println(LivroController.getLivroByNome("Duna"));   
        //System.out.println(LivroController.getLivroByID("5"));   
        // System.out.println(LivroController.getLivroByGenero("Romance").get(1));   
        //getLivroByNome("Duna");         
        //getAllUsers();
        //var teste = UserController.login("admin", "admin");
        //System.out.println(UsuarioDAO.Login("admin","admin").get(0));
<<<<<<< HEAD
        //System.out.println(teste);
        // getAdmin("admin");         
        // criarUsuario(new User("Rodrig","Bossii","rbossini","teste"));
        //System.out.println(LivroController.getAllLivros().get(5).getNome());
        //System.out.println();
        //System.out.println(LivroDAO.getGeneroByLivroId(1));
        //TelaLogin.main(null);
        System.out.println(AvaliacaoDAO.insertAvaliacaoByUsuarioId(1,3,7));
        //TelaBiblioteca.RenderizaLivros();
        //System.out.println(UsuarioDAO.Login("admin", "admin"));
=======
        // System.out.println(teste);
        // getAdmin("admin");
        // criarUsuario(new User("Rodrig","Bossii","rbossini","teste"));
        //System.out.println(LivroController.getAllLivros().get(5).getNome());
        //System.out.println(UserController.getAllUsuarios());
        //System.out.println(UsuarioDAO.getUsuariosFavoritos(1));
        //System.out.println(LivroDAO.getGeneroByLivroId(1));
        // TelaLogin.main(null);
        //System.out.println(UsuarioDAO.getUsuariosFavoritos(3));
        //System.out.println(AvaliacaoDAO.insertAvaliacaoByUsuarioId(1,3,7));
        //TelaBiblioteca.RenderizaLivros();
        //System.out.println(UsuarioDAO.Login("admin", "admin"));
       // System.out.println(LivroController.getLivroByName("Duna"));
       //System.out.println(LivroController.insertNewLivro("null", "null", 0, "null"));
>>>>>>> origin/teste
    }
}
