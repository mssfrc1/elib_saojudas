package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.UsuarioDAO;
import models.User;
import persistence.BancoDados;

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

    public static int getLastUsuarioId() {
       return UsuarioDAO.getLastUsuarioId();
    }
}
