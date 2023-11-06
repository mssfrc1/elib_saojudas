package controllers;

import DAO.UsuarioDAO;
import views.*;

public class UserController {

    public static boolean login(String usuario, String senha) {
        return UsuarioDAO.Login(usuario, senha) != null ? true : false; 
    }

    public static void Login(){
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}