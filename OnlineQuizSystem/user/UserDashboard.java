package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserDashboard extends JFrame {
    public UserDashboard(String username) {
        setTitle("Welcome " + username);
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton startQuizBtn = new JButton("Start Quiz");
        startQuizBtn.addActionListener(e -> {
            dispose();
            new QuizPanel(username);
        });

        add(startQuizBtn);
        setVisible(true);
    }
}