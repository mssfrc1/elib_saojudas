package controllers;

import DAO.UsuarioDAO;

public class UserController {

    public static boolean login(String usuario, String senha) {
        return UsuarioDAO.Login(usuario, senha) != null ? true : false; 
    }
}