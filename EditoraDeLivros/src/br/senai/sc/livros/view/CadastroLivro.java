package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivroController;
import br.senai.sc.livros.model.entities.Pessoa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroLivro extends JFrame {
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JTextField tituloInput;
    private JTextField isbnInput;
    private JTextField paginasInput;
    private JPanel cadastroLivro;

    public CadastroLivro(Pessoa pessoa) {
        criarComponentes();
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
//                Menu menu = new Menu();
//                menu.setVisible(true);
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tituloInput.getText().isEmpty() || isbnInput.getText().isEmpty() || paginasInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Há campos vazios!\n" +
                            "Preencha e tente novamente!");
                } else {
                    LivroController controller = new LivroController();
                    try {
                        controller.cadastrar(tituloInput.getText(), isbnInput.getText(), paginasInput.getText(), pessoa);
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }
        });
    }

    private void criarComponentes() {
        setContentPane(cadastroLivro);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

}
