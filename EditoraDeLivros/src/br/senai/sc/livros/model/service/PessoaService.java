package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.PessoaDAO;
import br.senai.sc.livros.model.entities.Pessoa;

public class PessoaService {

    PessoaDAO dao = new PessoaDAO();

    public void inserir(Pessoa pessoa) {
        dao.inserir(pessoa);
    }

    public void remover(Pessoa pessoa) {
        dao.remover(pessoa);
    }

    public Pessoa selecionarPorCPF(String cpf) {
        return dao.selecionarPorCPF(cpf);
    }

    public Pessoa selecionarPorEmail(String email) {
        return dao.selecionarPorEmail(email);
    }

    public void atualizar(String cpf, Pessoa pessoaAtualizada) {
        dao.atualizar(cpf, pessoaAtualizada);
    }

}
