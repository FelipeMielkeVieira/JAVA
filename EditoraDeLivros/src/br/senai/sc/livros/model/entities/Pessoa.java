package br.senai.sc.livros.model.entities;

public class Pessoa {

    public Pessoa() {

    }

    public Pessoa(String nome, String sobrenome, String email, String senha, String cpf, Genero genero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.genero = genero;
    }

    private String nome, sobrenome, email, senha, cpf;
    private Genero genero;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Pessoa validaLogin(String senha) {
        if (this.getSenha().equals(senha)) {
            return this;
        }
        throw new RuntimeException("Senha Incorreta!");
    }

    public static Pessoa cadastrar(String nome, String sobrenome, String email, String senha, String cpf,
                                   Genero genero, String confirmarSenha) {
        if(senha.equals(confirmarSenha)) {
            if(email.contains("@")) {
                return new Pessoa(nome, sobrenome, email, senha, cpf, genero);
            }
            throw new RuntimeException("Email Incorreto!");
        }
        throw new RuntimeException("As senhas não conferem!");
    }
}
