package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;
import br.senai.sc.livros.model.entities.Pessoa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements Runnable {
    private JTextField emailInput;
    private JPasswordField passwordInput;
    private JButton cadastreSeButton;
    private JButton loginButton;
    private JPanel login;

    public Login() {
        criarComponentes();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaController controller = new PessoaController();
                try {
                    Pessoa pessoa = controller.validaLogin(emailInput.getText(), passwordInput.getText());
                    dispose();
                    Menu menu = new Menu(pessoa);
                    menu.setVisible(true);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
        cadastreSeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CadastroPessoa cadastroPessoa = new CadastroPessoa();
                cadastroPessoa.setVisible(true);
            }
        });
    }

    private void criarComponentes() {
        setContentPane(login);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void run() {
        if (!isVisible()) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela já está aberta!");
        }
    }

    public static void main(String[] args) {
        Login programa = new Login();
        programa.run();
    }
}
