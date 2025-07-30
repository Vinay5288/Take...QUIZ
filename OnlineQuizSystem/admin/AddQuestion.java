package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import db.DBConnection;

public class AddQuestion extends JFrame implements ActionListener {
    JTextField qField, aField, bField, cField, dField, ansField;
    JButton addBtn;

    public AddQuestion() {
        setTitle("Add Question");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        qField = new JTextField();
        aField = new JTextField();
        bField = new JTextField();
        cField = new JTextField();
        dField = new JTextField();
        ansField = new JTextField();
        addBtn = new JButton("Add");

        add(new JLabel("Question:")); add(qField);
        add(new JLabel("Option A:")); add(aField);
        add(new JLabel("Option B:")); add(bField);
        add(new JLabel("Option C:")); add(cField);
        add(new JLabel("Option D:")); add(dField);
        add(new JLabel("Correct Option (A/B/C/D):")); add(ansField);
        add(addBtn);

        addBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO questions VALUES (questions_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, qField.getText());
            ps.setString(2, aField.getText());
            ps.setString(3, bField.getText());
            ps.setString(4, cField.getText());
            ps.setString(5, dField.getText());
            ps.setString(6, ansField.getText().toUpperCase());
            ps.executeUpdate();
            ps.close(); con.close();
            JOptionPane.showMessageDialog(this, "Question Added");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}