package controllers;
import java.util.List;

import DAO.LivroDAO;
import models.Livro;

public class LivroController {

public static List<Livro> getAllLivros() {
    return LivroDAO.getAllLivros();
}




}
