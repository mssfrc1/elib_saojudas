import java.util.Arrays;

import controllers.*;
import models.User;
import views.livro.TelaBiblioteca;
import views.usuario.TelaLogin;
import DAO.*;

public class elib {
    public static void main(String[] args) {
        // Chamando o metodo do LivroController
        //System.out.println(LivroController.getAllLivros());
        //System.out.println(LivroController.getLivroByNome("Duna"));   
        //System.out.println(LivroController.getLivroByID("5"));   
        // System.out.println(LivroController.getLivroByGenero("Romance").get(1));   
        //getLivroByNome("Duna");         
        //getAllUsers();
        //var teste = UserController.login("admin", "admin");
        //System.out.println(UsuarioDAO.Login("admin","admin").get(0));
        //System.out.println(teste);
        // getAdmin("admin");         
        // criarUsuario(new User("Rodrig","Bossii","rbossini","teste"));
        //System.out.println(LivroController.getAllLivros().get(5).getNome());
        //System.out.println();
        //System.out.println(LivroDAO.getGeneroByLivroId(1));
        TelaLogin.main(null);
        //System.out.println(AvaliacaoDAO.insertAvaliacaoByUsuarioId(1,3,7));
        //TelaBiblioteca.RenderizaLivros();
        //System.out.println(UsuarioDAO.Login("admin", "admin"));
       // System.out.println(LivroController.getLivroByName("Duna"));
       //System.out.println(LivroController.insertNewLivro("null", "null", 0, "null"));
    }
}
