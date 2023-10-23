package models;

public class Livro {
    private int id;
    private String nome;
    private String sinopse;
    private String capa;
    private String arquivo_livro;
    private String id_genero;
    private String genero;

    public Livro(int id, String nome, String sinopse, String capa, String arquivo_livro, String id_genero) {
    this.id = id;
    this.nome = nome;
    this.sinopse = sinopse;
    this.capa = capa;
    this.arquivo_livro = arquivo_livro;
    this.id_genero = id_genero;
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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
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
     public void setGenero(String genero) {
         this.genero = genero;
     }

    public String getGenero() {
        return genero;
    }

    public String getId_genero() {
        return id_genero;
    }

    public void setId_genero(String id_genero) {
        this.id_genero = id_genero;
    }

    public String toString() {
        return "Livro [id=" + id + ", nome=" + nome + ", sinopse=" + sinopse + ", capa=" + capa + ", arquivo_livro=" + arquivo_livro + ", genero=" + genero + ", id_genero=" + id_genero + "]";
    }


}
