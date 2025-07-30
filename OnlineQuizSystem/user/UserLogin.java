package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import db.DBConnection;

public class UserLogin extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn, registerBtn;

    public UserLogin() {
        setTitle("User Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginBtn = new JButton("Login");
        registerBtn = new JButton("Register");

        loginBtn.addActionListener(this);
        registerBtn.addActionListener(this);

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginBtn);
        add(registerBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (e.getSource() == loginBtn) {
            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM userss WHERE username=? AND password=?");
                ps.setString(1, user);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    dispose();
                    new UserDashboard(user);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Login");
                }
                rs.close(); ps.close(); con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == registerBtn) {
            dispose();
            new UserRegister();
        }
    }
}