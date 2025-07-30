package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import db.DBConnection;

public class UserRegister extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton registerBtn;

    public UserRegister() {
        setTitle("User Register");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        registerBtn = new JButton("Register");

        registerBtn.addActionListener(this);

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(registerBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO userss VALUES (?, ?)");
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registered Successfully!");
            ps.close(); con.close();
            dispose();
            new UserLogin();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}