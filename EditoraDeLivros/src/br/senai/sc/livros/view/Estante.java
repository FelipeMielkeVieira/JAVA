package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivroController;

import javax.swing.*;

public class Estante extends JFrame {
    private JPanel estante;
    private JTable tabelaLivros;
    private JButton voltarButton;
    private JButton editarButton;

    public Estante() {
        criarComponentes();
    }

    private void criarComponentes() {
        LivroController controller = new LivroController();
        tabelaLivros.setModel(new DefaultTableModelArrayList(controller.buscarLista()));
        tabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setContentPane(estante);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}
