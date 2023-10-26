package controllers;

import java.util.List;

import DAO.UsuarioDAO;
import models.User;

public class UserController {

    public static boolean login(String usuario, String senha) {
        return UsuarioDAO.Login(usuario, senha) != null ? true : false; 
    }
}