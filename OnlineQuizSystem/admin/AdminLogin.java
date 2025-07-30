package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    public AdminLogin() {
        setTitle("Admin Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        userField = new JTextField();
        passField = new JPasswordField();
        loginBtn = new JButton("Login");

        loginBtn.addActionListener(this);

        add(new JLabel("Admin Username:"));
        add(userField);
        add(new JLabel("Password:"));
        add(passField);
        add(loginBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (userField.getText().equals("admin") && new String(passField.getPassword()).equals("admin")) {
            dispose();
            new AdminDashboard();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Admin Login");
        }
    }
}