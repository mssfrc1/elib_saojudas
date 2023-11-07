package controllers;

import java.util.List;

import DAO.UsuarioDAO;
import models.Livro;
import models.User;

public class UserController {

    public static User login(String usuario, String senha) {
        var user = UsuarioDAO.Login(usuario, senha); 
        return user;
    }

    
}