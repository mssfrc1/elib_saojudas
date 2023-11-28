package models;

public class User {
    private int id;
    private String nome;
    private String sobrenome;
    private String usuario;
    private String senha;
<<<<<<< HEAD
=======
    private String generoFav;
>>>>>>> origin/teste
    private int idade;
    private String sexo;
    private boolean admin;

<<<<<<< HEAD
    public User () {}

    public User(int id, String nome, String sobrenome, String usuario, String senha, int idade, String sexo, boolean admin) {
        this.id = id;
=======
    public User() {
    }

    public User(String nome, String sobrenome, String usuario, String senha, int idade, String sexo) {
>>>>>>> origin/teste
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.usuario = usuario;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
<<<<<<< HEAD
        this.admin = admin;
=======
>>>>>>> origin/teste
    }

    public User(String nome, String sobrenome, String usuario, String senha, int idade, String sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.usuario = usuario;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Object[] toArray() {
        return new Object[] { id, nome, sobrenome, usuario, senha, idade, sexo, admin };
    }

    public String toString() {
        return "|ID: " + id + ", " + "Nome: " + nome + ", " + "Sobrenome: " + sobrenome + ", " + "Usuario: " + usuario
                + ", " + "Senha " + senha + ", " + "Admin: " + admin;
    }

<<<<<<< HEAD
=======
    public String getGeneroFav() {
        return generoFav;
    }

    public void setGeneroFav(String generoFav) {
        this.generoFav = generoFav;
    }
    
>>>>>>> origin/teste
}