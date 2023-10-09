package models;

public class Livro {
    private int id;
    private String nome;
    private String sinopse;
    private String genero;
    private String capa;
    private String arquivo_livro;

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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getArquivo_livro() {
        return arquivo_livro;
    }

    public void setArquivo_livro(String arquivo_livro) {
        this.arquivo_livro = arquivo_livro;
    }

    public String toString() {
        return "|ID: " + id + ", " + "Nome: " + nome + ", " + "Sinopse: " + sinopse + ", " + "Genero: " + genero + ", " + "Capa " + capa + ", " + "Admin: " + arquivo_livro;
    }
}
