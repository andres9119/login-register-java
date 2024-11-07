package main.java.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.dao.UserDAO;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterForm() {
        setTitle("Register Form");
        setLayout(new GridLayout(3, 2)); // Grid para 2 columnas

        // Crear los componentes
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        registerButton = new JButton("Register");

        // Agregar los componentes al JFrame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);

        // Acción al presionar el botón de registro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Crear una instancia de UserDAO para registrar el usuario
                UserDAO userDAO = new UserDAO();
                boolean success = userDAO.registerUser(username, password);
                if (success) {
                    JOptionPane.showMessageDialog(RegisterForm.this, "Registration successful!");
                } else {
                    JOptionPane.showMessageDialog(RegisterForm.this, "Registration failed.");
                }
            }
        });

        // Configurar ventana
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar la ventana
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }
}
