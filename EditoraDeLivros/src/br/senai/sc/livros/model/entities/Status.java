package br.senai.sc.livros.model.entities;

public enum Status {

    AGUARDANDO_REVISAO("Aguardando Revisão"), EM_REVISAO("Em Revisão"), REPROVADO("Reprovado"), AGUARDANDO_EDICAO("Aguardando Edi"), APROVADO("Aprovado"), PUBLICADO("Publicado");

    String nome;

    Status(String nome) {
        this.nome = nome;
    }
}
