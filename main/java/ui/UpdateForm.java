package main.java.ui;

import main.java.dao.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField newPasswordField;
    private JButton updateButton;
    private JButton deleteButton;

    public UpdateForm() {
        setTitle("User Management");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuración de los componentes visuales
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(230, 240, 255));

        JLabel titleLabel = new JLabel("User Update & Delete");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(60, 70, 92));

        // Campos de texto
        usernameField = new JTextField(15);
        newPasswordField = new JPasswordField(15);

        // Configuración de botones
        updateButton = new JButton("Update Password");
        updateButton.setBackground(new Color(70, 130, 180));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateButton.setMaximumSize(new Dimension(200, 30));

        deleteButton = new JButton("Delete User");
        deleteButton.setBackground(new Color(178, 34, 34));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteButton.setMaximumSize(new Dimension(200, 30));

        // Agregar acción a los botones
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePassword();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        // Agregar componentes al panel principal
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        mainPanel.add(new JLabel("Username:"));
        mainPanel.add(usernameField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        mainPanel.add(new JLabel("New Password:"));
        mainPanel.add(newPasswordField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        mainPanel.add(updateButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(deleteButton);

        // Añadir panel principal al marco
        add(mainPanel);
    }

    private void updatePassword() {
        String username = usernameField.getText();
        String newPassword = new String(newPasswordField.getPassword());

        if (username.isEmpty() || newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.updateUser(username, newPassword);

        if (success) {
            JOptionPane.showMessageDialog(this, "Password updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update password.");
        }
    }

    private void deleteUser() {
        String username = usernameField.getText();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the username.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            UserDAO userDAO = new UserDAO();
            boolean success = userDAO.deleteUser(username);

            if (success) {
                JOptionPane.showMessageDialog(this, "User deleted successfully.");
                usernameField.setText("");
                newPasswordField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete user.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UpdateForm().setVisible(true);
            }
        });
    }
}
