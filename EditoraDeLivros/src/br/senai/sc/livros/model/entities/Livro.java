package br.senai.sc.livros.model.entities;

public class Livro {

    private Autor autor;
    private Editora editora;
    private String titulo;
    private int isbn, qtdPaginas;
    private Status status;

    public Livro(String titulo, int isbn, int qtdPaginas, Autor autor,  Status status) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.qtdPaginas = qtdPaginas;
        this.autor = autor;
        this.status = status;
    }

    public Livro() {

    }

    public Autor getAutor() {
        return autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public Status getStatus() {
        return status;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public static Livro cadastrar(String titulo, int isbn, int qtdPaginas, Autor autor) {
        return new Livro(titulo, isbn, qtdPaginas, autor, Status.AGUARDANDO_REVISAO);
    }
}
