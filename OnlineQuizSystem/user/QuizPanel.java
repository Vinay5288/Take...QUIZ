package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class QuizPanel extends JFrame implements ActionListener {
    JLabel qLabel;
    JRadioButton optA, optB, optC, optD;
    JButton nextBtn;
    ButtonGroup optionsGroup;

    ArrayList<Question> questionList;
    int currentQuestionIndex = 0;
    int score = 0;
    String selectedAnswer = "";
    String username;

    public QuizPanel(String username) {
        this.username = username;

        setTitle("Quiz");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        qLabel = new JLabel();
        qLabel.setFont(new Font("Arial", Font.BOLD, 16));

        optA = new JRadioButton();
        optB = new JRadioButton();
        optC = new JRadioButton();
        optD = new JRadioButton();

        optionsGroup = new ButtonGroup();
        optionsGroup.add(optA);
        optionsGroup.add(optB);
        optionsGroup.add(optC);
        optionsGroup.add(optD);

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(qLabel);
        panel.add(optA);
        panel.add(optB);
        panel.add(optC);
        panel.add(optD);
        panel.add(nextBtn);

        add(panel);

        loadQuestions();
        showQuestion();

        setVisible(true);
    }

    public void loadQuestions() {
        questionList = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "vinay123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM questions");

            while (rs.next()) {
                Question q = new Question(
                        rs.getInt("question_id"),
                        rs.getString("question_text"),
                        rs.getString("option_a"),
                        rs.getString("option_b"),
                        rs.getString("option_c"),
                        rs.getString("option_d"),
                        rs.getString("correct_option")
                );
                questionList.add(q);
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading questions: " + e.getMessage());
        }
    }

    public void showQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question q = questionList.get(currentQuestionIndex);
            qLabel.setText("Q" + (currentQuestionIndex + 1) + ": " + q.questionText);
            optA.setText("A. " + q.optionA);
            optB.setText("B. " + q.optionB);
            optC.setText("C. " + q.optionC);
            optD.setText("D. " + q.optionD);
            optionsGroup.clearSelection();
        } else {
            endQuiz();
        }
    }

    public void endQuiz() {
        // Save result
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "vinay123");
            PreparedStatement ps = con.prepareStatement("INSERT INTO results(username, score) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setInt(2, score);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving result: " + e.getMessage());
        }

        // Show score
        JOptionPane.showMessageDialog(this, "Quiz Finished!\nYour Score: " + score + "/" + questionList.size());
        System.exit(0);
    }

    public void actionPerformed(ActionEvent e) {
        Question q = questionList.get(currentQuestionIndex);
        if (optA.isSelected()) selectedAnswer = "A";
        else if (optB.isSelected()) selectedAnswer = "B";
        else if (optC.isSelected()) selectedAnswer = "C";
        else if (optD.isSelected()) selectedAnswer = "D";
        else selectedAnswer = "";

        if (!selectedAnswer.equals("")) {
            if (selectedAnswer.equalsIgnoreCase(q.correctOption)) {
                score++;
            }
            currentQuestionIndex++;
            showQuestion();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
        }
    }

    class Question {
        int id;
        String questionText, optionA, optionB, optionC, optionD, correctOption;

        public Question(int id, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
            this.id = id;
            this.questionText = questionText;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctOption = correctOption;
        }
    }
}