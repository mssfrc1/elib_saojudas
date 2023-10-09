package controllers;

import java.util.List;
import DAOs.LivroDAO;
import models.Livro;

public class LivroController {
    
    public static Livro[] getAllLivros() {
        List<Livro> livrosList = LivroDAO.getAllLivros();

        if (livrosList != null) {
            Livro[] livrosArray = new Livro[livrosList.size()];
            livrosArray = livrosList.toArray(livrosArray);

            return livrosArray;
        } else {
            System.out.println("Falha ao conectar no banco de dados");
            return null;
        }
    }

    public static Livro getLivroById(int livroId) {
        return LivroDAO.getLivroById(livroId);
    }

    public static Livro[] getLivrosByGenero(String generoLivro) {
        List<Livro> livroList = LivroDAO.getLivroByGenero(generoLivro);

        if (livroList != null) {
            Livro[] livrosArray = new Livro[livroList.size()];
            livrosArray = livroList.toArray(livrosArray);

            return livrosArray;
        } else {
            System.out.println("Falha ao conectar ao Banco de Dados");
            return null;
        }
    }

    public static Livro[] getLivrosByNome(String nomeLivro) {
        List<Livro> livroList = LivroDAO.getLivroByGenero(nomeLivro);

        if (livroList != null) {
            Livro[] livrosArray = new Livro[livroList.size()];
            livrosArray = livroList.toArray(livrosArray);

            return livrosArray;
        } else {
            System.out.println("Falha ao conectar ao Banco de Dados");
            return null;
        }
    }    
}
