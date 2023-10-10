import java.util.Arrays;
import java.util.List;

import controllers.*;
import models.Livro;
import models.User;
import views.TelaLogin;

public class elib {
    public static void main(String[] args) {
        // Chamando o metodo do LivroController
        //System.out.println(LivroController.getAllLivros());
        //System.out.println(LivroController.getLivroByNome("Duna"));     
        System.out.println(LivroController.getLivroByGenero("Romance").get(1));   
        //getLivroByNome("Duna");         
        //getAllUsers();
        //login("rbossini","teste");
        //getAdmin("admin");         
        //criarUsuario(new User("Rodrig","Bossii","rbossini","teste")); 
        //telaLogin();
    }
}
