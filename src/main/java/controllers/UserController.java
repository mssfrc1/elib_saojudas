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

    public static int criarUsuario(User usuario) {
        return UsuarioDAO.criarUsuario(new User(usuario.getNome(),usuario.getSobrenome(),usuario.getUsuario(),usuario.getSenha(),usuario.getIdade(),usuario.getSexo()));
    }
}
