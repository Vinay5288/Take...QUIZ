package admin;

import javax.swing.*;
import java.sql.*;
import db.DBConnection;

public class ViewResults extends JFrame {
    JTextArea area;

    public ViewResults() {
        setTitle("View Results");
        setSize(400, 300);
        area = new JTextArea();
        add(new JScrollPane(area));
        setVisible(true);

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM results");

            while (rs.next()) {
                area.append("User: " + rs.getString("username") + " | Score: " + rs.getInt("score") + "\n");
            }

            rs.close(); stmt.close(); con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}