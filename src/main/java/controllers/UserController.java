package controllers;

import java.util.List;

import DAO.UsuarioDAO;
import models.User;

public class UserController {

    public static boolean login(String usuario, String senha) {
        if (UsuarioDAO.Login(usuario, senha) != null) {
            return true;
        }
        System.out.println("Falha na autenticação");
        return false;
    }

}