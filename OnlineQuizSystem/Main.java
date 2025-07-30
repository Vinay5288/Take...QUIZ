import javax.swing.*;
import java.awt.*;
import user.UserLogin;
import admin.AdminLogin;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Online Quiz System");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new GridLayout(2, 1, 10, 10));

            JButton userBtn = new JButton("User Login");
            JButton adminBtn = new JButton("Admin Login");

            userBtn.addActionListener(e -> {
                new UserLogin();
                frame.dispose(); // close main window
            });

            adminBtn.addActionListener(e -> {
                new AdminLogin();
                frame.dispose(); // close main window
            });

            frame.add(userBtn);
            frame.add(adminBtn);

            frame.setVisible(true);
        });
    }
}