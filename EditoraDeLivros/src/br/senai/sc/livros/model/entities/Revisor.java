package br.senai.sc.livros.model.entities;

public class Revisor extends Pessoa {

    public Revisor() {
    }

    public Revisor(String nome, String sobrenome, String email, String senha, String cpf, Genero genero) {
        super(nome, sobrenome, email, senha, cpf, genero);
    }
}
