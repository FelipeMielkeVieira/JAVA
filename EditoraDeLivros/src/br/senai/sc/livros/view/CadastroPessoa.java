package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;
import br.senai.sc.livros.model.entities.Genero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPessoa extends JFrame {
    private JButton cadastrarButton;
    private JButton voltarButton;
    private JTextField nomeInput;
    private JTextField sobrenomeInput;
    private JTextField emailInput;
    private JTextField cpfInput;
    private JComboBox generoInput;
    private JPasswordField senhaInput;
    private JPasswordField confirmarInput;
    private JPanel cadastroPessoa;

    public CadastroPessoa() {
        criarComponentes();
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomeInput.getText().isEmpty() || sobrenomeInput.getText().isEmpty() ||
                        emailInput.getText().isEmpty() || cpfInput.getText().isEmpty() ||
                        senhaInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Há campos vazios!\nPreencha e tente novamente!");
                } else {
                    PessoaController controller = new PessoaController();
                    try {
                        controller.cadastrar(nomeInput.getText(), sobrenomeInput.getText(),
                                emailInput.getText(), senhaInput.getText(), cpfInput.getText(),
                                generoInput.getSelectedItem(), confirmarInput.getText());
                        dispose();
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                        voltar();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                voltar();
            }
        });
    }

    private void criarComponentes() {
        generoInput.setModel(new DefaultComboBoxModel(Genero.values()));
        setContentPane(cadastroPessoa);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }

    private void voltar() {
        if(Menu.getUsuario() == null) {
            Login login = new Login();
            login.run();
        } else {
            Menu menu = new Menu(Menu.getUsuario());
            menu.setVisible(true);
        }
    }
}
