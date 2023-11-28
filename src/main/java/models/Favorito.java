package models;

public class Favorito {
    private String id_usuario;
    private String[] id_genero = new String[2];


    public String getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String[] getId_genero() {
        return id_genero;
    }
    public void setId_genero(String[] id_genero) {
        this.id_genero = id_genero;
    }

}