package controllers;

import DAO.UsuarioDAO;

public class UserController {

    //Indíce 0 para ver se ele é autentico e Indíce 1 para ver se ele é ADMIN
    public static Boolean[] login(String usuario, String senha) {
        var resultados = new Boolean[2];
        var usuarioInput = UsuarioDAO.Login(usuario, senha);

        resultados[0] = usuarioInput != null;
        resultados[1] = resultados[0] && usuarioInput.getAdmin();

        return resultados;
    }
}