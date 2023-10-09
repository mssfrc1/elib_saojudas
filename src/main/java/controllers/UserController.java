package controllers;

import java.util.List;

import DAOs.UserDAO;
import models.User;

public class UserController {
    public static List<User> getAllUsers() {
        List<User> usersList = UserDAO.getAllUsers();
        return usersList;
    }

    public static boolean login(String usuario, String senha) {
        boolean statusVerificacao = false;
        List<User> listaUsersSenhas = UserDAO.getUsuarioSenha(usuario, senha);
        Boolean verificacaoLista = listaUsersSenhas.stream()
                .map(n -> n.getUsuario() + " " + n.getSenha())
                .toList()
                .isEmpty();

        // Verificação de Usuario
        if (verificacaoLista == false) {
            statusVerificacao = true;
        }

        return statusVerificacao;
    }

    public static boolean verificacaoUsuarioAdmin(String usuario) {
        List<User> listaUserAdmin = UserDAO.getAdmin(usuario);
        Boolean verificacaoLista = listaUserAdmin.stream()
                .map(n -> n.getAdmin())
                .toList()
                .contains(true);

        return verificacaoLista;
    }

    public static void criarUsuario(User user) {
        UserDAO.createUser(user);
    }
}