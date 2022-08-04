package br.senai.sc.livros.model.entities;

public class Diretor extends Pessoa {

    public Diretor() {
    }

    public Diretor(String nome, String sobrenome, String email, String senha, String cpf, Genero genero) {
        super(nome, sobrenome, email, senha, cpf, genero);
    }
}
