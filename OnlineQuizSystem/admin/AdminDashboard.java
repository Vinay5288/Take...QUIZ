package admin;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(300, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton addQBtn = new JButton("Add Question");
        JButton viewResultsBtn = new JButton("View Results");

        addQBtn.addActionListener(e -> {
            new AddQuestion();
        });

        viewResultsBtn.addActionListener(e -> {
            new ViewResults();
        });

        add(addQBtn);
        add(viewResultsBtn);
        setVisible(true);
    }
}