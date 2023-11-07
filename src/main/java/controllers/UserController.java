package controllers;

import DAO.UsuarioDAO;
import models.User;

public class UserController {
    
    public static User usuarioLogado;

    public static User login(String usuario, String senha) {
        var user = UsuarioDAO.Login(usuario, senha);
        if (user != null) {
            usuarioLogado = user;
        }
        return user;
    }
}
