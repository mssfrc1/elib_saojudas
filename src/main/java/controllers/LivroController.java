package controllers;

import java.util.List;

import DAO.LivroDAO;
import models.Livro;

public class LivroController {

    public static List<Livro> getAllLivros() {
        return LivroDAO.getAllLivros();
    }

    public static int insertNewLivro(Livro livro) {
        return LivroDAO.criarLivro(new Livro(livro.getNome(), livro.getSinopse(),livro.getId_genero(), livro.getAutor()));
    }
}
