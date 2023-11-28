package controllers;
import java.util.Arrays;
import java.util.List;
<<<<<<< HEAD
import java.util.Objects;
=======
>>>>>>> origin/teste

import DAO.LivroDAO;
import models.Livro;

public class LivroController {

<<<<<<< HEAD
public static List<Livro> getAllLivros() {
    return LivroDAO.getAllLivros();
}


=======
    public static List<Livro> getAllLivros() {
        return LivroDAO.getAllLivros();
    }

    public static int insertNewLivro(String nome, String sinopse, int id_genero, String autor) {
        return LivroDAO.criarLivro(nome, sinopse, id_genero, autor);
    }

    public static int getLastLivroId(){
        return LivroDAO.getLastLivroId();
    }

    public static List<String> filterByName() {
        return getAllLivros().stream()
        .map(n -> n.getNome())
        .toList();
    }

    public static Livro getLivroByNome(String nomeLivro) {
        return LivroDAO.getLivroByNome(nomeLivro);
    }
>>>>>>> origin/teste
}
