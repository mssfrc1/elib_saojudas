package controllers;

import java.util.List;

import DAO.LivroDAO;
import models.Livro;

public class LivroController {

    public static List<Livro> getAllLivros() {
        return LivroDAO.getAllLivros();
    }

    public static int insertNewLivro(String nome, String sinopse, int id_genero, String autor) {
        return LivroDAO.criarLivro(nome, sinopse, id_genero, autor);
    }

    public static List<String> filterByName() {
        return getAllLivros().stream()
        .map(n -> n.getNome())
        .toList();
    }

}
