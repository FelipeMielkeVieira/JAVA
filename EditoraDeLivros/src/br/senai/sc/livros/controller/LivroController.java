package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.*;
import br.senai.sc.livros.model.service.LivroService;

import java.util.ArrayList;

public class LivroController {

    Livro model;

    public Autor getAutor() {
        return model.getAutor();
    }

    public Editora getEditora() {
        return model.getEditora();
    }

    public String getTitulo() {
        return model.getTitulo();
    }

    public Status getStatus() {
        return model.getStatus();
    }

    public int getIsbn() {
        return model.getIsbn();
    }

    public int getQtdPaginas() {
        return model.getQtdPaginas();
    }

    public void setAutor(Autor autor) {
        model.setAutor(autor);
    }

    public void setEditora(Editora editora) {
        model.setEditora(editora);
    }

    public void setTitulo(String titulo) {
        model.setTitulo(titulo);
    }

    public void setStatus(Status status) {
        model.setStatus(status);
    }

    public void setIsbn(int isbn) {
        model.setIsbn(isbn);
    }

    public void setQtdPaginas(int qtdPaginas) {
        model.setQtdPaginas(qtdPaginas);
    }

    public void cadastrar(String titulo, String isbn, String qtdPaginas, Pessoa pessoa) {
        Livro livro = Livro.cadastrar(titulo, Integer.parseInt(isbn), Integer.parseInt(qtdPaginas), (Autor) (pessoa));
    }

    public ArrayList<Livro> buscarLista() {
        LivroService service = new LivroService();
        return service.selecionarTodos();
    }
}
