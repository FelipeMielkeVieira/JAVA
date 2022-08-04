package br.senai.sc.livros.view;

import br.senai.sc.livros.model.entities.Autor;
import br.senai.sc.livros.model.entities.Diretor;
import br.senai.sc.livros.model.entities.Pessoa;
import br.senai.sc.livros.model.entities.Revisor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private JButton sairButton;
    private JPanel menu;
    private JButton cadastrarLivrosButton;
    private JButton listarLivrosButton;
    private JButton listarAtividadesButton;
    private JButton cadastrarRevisorButton;
    private static Pessoa usuario;

    public static Pessoa getUsuario() {
        return usuario;
    }

    public Menu(Pessoa pessoa) {
        usuario = pessoa;
        criarComponentes();
    }

    private void criarComponentes() {
        setContentPane(menu);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        cadastrarLivrosButton.addActionListener(this);
        cadastrarLivrosButton.setActionCommand("cadastrarLivro");
        listarLivrosButton.addActionListener((this));
        listarLivrosButton.setActionCommand("listarLivros");
        listarAtividadesButton.addActionListener(this);
        listarAtividadesButton.setActionCommand("listarAtividades");
        cadastrarRevisorButton.addActionListener(this);
        cadastrarRevisorButton.setActionCommand("cadastrarRevisor");
        sairButton.addActionListener(this);
        sairButton.setActionCommand("sair");

        if(usuario instanceof Autor || usuario instanceof Revisor) {
            cadastrarRevisorButton.setVisible(false);
        }
        if(usuario instanceof Revisor || usuario instanceof Diretor) {
            cadastrarLivrosButton.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cadastrarLivro")) {
            dispose();
            CadastroLivro cadastroLivro = new CadastroLivro(usuario);
            cadastroLivro.setVisible(true);
        } else if (e.getActionCommand().equals("listarLivros")) {
            dispose();
            Estante estante = new Estante();
            estante.setVisible(true);
        } else if (e.getActionCommand().equals("listarAtividades")) {
            dispose();
            Estante estante = new Estante();
            estante.setVisible(true);
        } else if (e.getActionCommand().equals("cadastrarRevisor")) {
            dispose();
            CadastroPessoa cadastroPessoa = new CadastroPessoa();
            cadastroPessoa.setVisible(true);
        } else if (e.getActionCommand().equals("sair")) {
            usuario = null;
            dispose();
            Login login = new Login();
            login.run();
        }
    }
}
