package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;

import java.util.ArrayList;

public class PessoaDAO {

    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    static {
        Autor autor = new Autor("Felipe", "Vieira", "felipe@gmail.com", "123", "123", Genero.MASCULINO);
        listaPessoas.add(autor);
        Revisor revisor = new Revisor("Kenzo", "Sato", "kenzo@gmail.com", "123", "123", Genero.FEMININO);
        listaPessoas.add(revisor);
        Diretor diretor = new Diretor("Matheus", "Hohmann", "matheus@gmail.com", "123", "123", Genero.OUTRO);
        listaPessoas.add(diretor);
    }

    public void inserir(Pessoa pessoa) {
        listaPessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        listaPessoas.remove(pessoa);
    }

    public Pessoa selecionarPorCPF(String cpf) {
        for(Pessoa pessoa: listaPessoas) {
            if(pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        throw new RuntimeException("Pessoa não encontrada!");
    }

    public Pessoa selecionarPorEmail(String email) {
        for(Pessoa pessoa: listaPessoas) {
            if(pessoa.getEmail().equals(email)) {
                return pessoa;
            }
        }
        throw new RuntimeException("E-mail não encontrado!");
    }

    public void atualizar(String cpf, Pessoa pessoaAtualizada) {
        for(int i = 0; i < listaPessoas.size(); i++) {
            if(listaPessoas.get(i).getCpf().equals(cpf)) {
                listaPessoas.set(i, pessoaAtualizada);
            }
        }
        throw new RuntimeException();
    }
}
