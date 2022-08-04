package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.LivroDAO;
import br.senai.sc.livros.model.entities.Livro;

import java.util.ArrayList;

public class LivroService {

    LivroDAO acesso = new LivroDAO();

    public void inserir(Livro livro) {
        acesso.inserir(livro);
    }

    public void remover(Livro livro) {
        acesso.remover(livro);
    }

    public Livro selecionar(int isbn) {
        return acesso.selecionar(isbn);
    }

    public void atualizar(int isbn, Livro livroAtualizado) {
        acesso.atualizar(isbn, livroAtualizado);
    }

    public ArrayList<Livro> selecionarTodos() {
        return acesso.selecionarTodos();
    }
}
