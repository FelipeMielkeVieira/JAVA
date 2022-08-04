package br.senai.sc.livros.model.entities;

public class Autor extends Pessoa {

    public Autor() {
    }

    public Autor(String nome, String sobrenome, String email, String senha, String cpf, Genero genero) {
        super(nome, sobrenome, email, senha, cpf, genero);
    }
}
