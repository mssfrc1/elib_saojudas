package controllers;
import java.util.List;

import DAO.AvaliacaoDAO;
import models.Avaliacao;

public class AvaliacaoController {

public static int insertAvaliacaoByUsuarioId(int id_usuario, int id_livro, int avaliacao){
    return AvaliacaoDAO.insertAvaliacaoByUsuarioId(id_usuario, id_livro, avaliacao);
}

}