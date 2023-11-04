package controllers;

import DAO.UsuarioDAO;
import models.User;

public class UserController {

    public static boolean login(String usuario, String senha) {
        return UsuarioDAO.Login(usuario, senha) != null ? true : false; 
    }

    public static int criarUsuario(User user) {
        return UsuarioDAO.criarUsuario(user);
    }

    public static boolean verificacaoUsuarioAdmin(String usuario) {
        return UsuarioDAO.verificacaoUsuarioAdmin(usuario) == true ? true : false; 
    }
}