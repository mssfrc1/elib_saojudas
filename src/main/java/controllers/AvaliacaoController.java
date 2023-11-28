package controllers;

import DAO.AvaliacaoDAO;
import models.Avaliacao;

public class AvaliacaoController {

public static int insertAvaliacao(int id_usuario, int id_livro, int avaliacao){
    return AvaliacaoDAO.insertAvaliacao(id_usuario, id_livro, avaliacao);
}

}