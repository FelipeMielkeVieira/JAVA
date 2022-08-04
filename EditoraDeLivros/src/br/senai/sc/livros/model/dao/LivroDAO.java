package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LivroDAO {

    private static ArrayList<Livro> listaLivros = new ArrayList<>();

    static {
        Autor autor = new Autor("Felipe", "Vieira", "felipe@gmail.com", "123", "123", Genero.MASCULINO);
        Livro livro = new Livro("Diário de um Banana", 1, 217, autor, Status.AGUARDANDO_REVISAO);
        listaLivros.add(livro);
    }

    public void inserir(Livro livro) {
        listaLivros.add(livro);
    }

    public void remover(Livro livro) {
        listaLivros.remove(livro);
    }

    public Livro selecionar(int isbn) {
        for(Livro livro: listaLivros) {
            if(livro.getIsbn() == isbn) {
                return livro;
            }
        }
        throw new RuntimeException();
    }

    public void atualizar(int isbn, Livro livroAtualizado) {
        for(int i = 0; i < listaLivros.size(); i++) {
            if(listaLivros.get(i).getIsbn() == isbn) {
                listaLivros.set(i, livroAtualizado);
            }
        }
        throw new RuntimeException();
    }

    public ArrayList<Livro> selecionarTodos() {
        return listaLivros;
    }

    public ArrayList<Livro> selecionarPorAutor(Pessoa pessoa) {
        ArrayList<Livro> livrosAutor = new ArrayList<>();
        for(int i = 0; i < listaLivros.size(); i++) {
            if(listaLivros.get(i).getAutor().equals(pessoa)) {
                livrosAutor.add(listaLivros.get(i));
            }
        }
        return livrosAutor;
    }

    public ArrayList<Livro> selecionarPorStatus(Status status) {
        ArrayList<Livro> livrosStatus = new ArrayList<>();
        for(int i = 0; i < listaLivros.size(); i++) {
            if(listaLivros.get(i).getStatus().equals(status)) {
                livrosStatus.add(listaLivros.get(i));
            }
        }
        return livrosStatus;
    }
}
