package models;

public class User {
    private int id;
    private String nome;
    private String sobrenome;
    private String usuario;
    private String senha;
    private boolean admin;

    public User() {}

    public User(String nome,String sobrenome,String usuario, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String toString() {
        return "|ID: " + id + ", " + "Nome: " + nome + ", " + "Sobrenome: " + sobrenome + ", " + "Usuario: " + usuario + ", " + "Senha " + senha + ", " + "Admin: " + admin;
    }
}