package controllers;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import DAO.LivroDAO;
import models.Livro;

public class LivroController {

public static List<Livro> getAllLivros() {
    return LivroDAO.getAllLivros();
}


}
