package DAO;

<<<<<<< HEAD
public class FavoritoDAO {
    
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import persistence.BancoDados;

public class FavoritoDAO {
   private static final String INSERT_FAVORITO = "INSERT INTO favorito (id_usuario, id_genero) VALUES (?, ?)";

        public static int insertAvaliacao(int id_usuario, int id_genero) {
        int resultado = 0;

        try (Connection connection = BancoDados.ConexaoDb();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FAVORITO)) {
            preparedStatement.setInt(1, id_usuario);
            preparedStatement.setInt(2, id_genero);

            resultado = preparedStatement.executeUpdate();
            
            if (resultado == 0) {
                System.out.println("Erro ao adicionar favorito");
            } else {
                System.out.println("Favorito adicionado com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
>>>>>>> origin/teste
}
