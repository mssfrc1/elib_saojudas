package controllers;

import java.util.List;

import DAO.UsuarioDAO;
import models.User;

public class UserController {

    public static Object login(String usuario, String senha) {
        return UsuarioDAO.Login(usuario, senha).toArray()[2];
    }

}