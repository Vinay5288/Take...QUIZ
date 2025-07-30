# Take...QUIZ
Here’s a complete README.md file for your Online Quiz System project built in Java using Swing and Oracle DB:


---

# 🧠 Online Quiz System (Java + Oracle DB)

A simple, GUI-based Online Quiz System developed using **Java Swing** and **Oracle SQL**. It supports both **User** and **Admin** logins, user registration, question management, and score tracking.

---

## 📌 Features

### 👤 User Module
- Register new account
- Login securely
- Take multiple-choice quizzes
- View final score

### 🔐 Admin Module
- Admin login panel
- Add, edit, or delete quiz questions
- View all submitted scores

### 🛠️ Tech Stack
- **Frontend:** Java Swing (JFrame, JPanel, etc.)
- **Backend:** Oracle DB (via JDBC)
- **Language:** Java (JDK 11+)
- **Database Driver:** ojdbc11.jar

---

## 🗃️ Database Schema

### 🔸 Table: `users`
| Column       | Type         | Description         |
|--------------|--------------|---------------------|
| id           | NUMBER       | Primary Key         |
| username     | VARCHAR2(50) | Unique user name    |
| password     | VARCHAR2(50) | User password       |

### 🔸 Table: `questions`
| Column        | Type          | Description        |
|---------------|---------------|--------------------|
| question_id   | NUMBER        | Primary Key        |
| question_text | VARCHAR2(200) | The question       |
| option_a      | VARCHAR2(100) | Option A           |
| option_b      | VARCHAR2(100) | Option B           |
| option_c      | VARCHAR2(100) | Option C           |
| option_d      | VARCHAR2(100) | Option D           |
| correct_option| CHAR(1)       | Correct answer (A-D) |

### 🔸 Table: `scores`
| Column     | Type         | Description           |
|------------|--------------|-----------------------|
| id         | NUMBER       | Primary Key           |
| user_id    | NUMBER       | Foreign Key (users)   |
| score      | NUMBER       | Total score obtained  |

---

## 🚀 How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/online-quiz-system.git
   cd online-quiz-system

2. Set up Oracle Database:

Create tables (users, questions, scores)

Insert some questions



3. Compile Java Code:

javac -cp ".;ojdbc11.jar" Main.java


4. Run the Application:

java -cp ".;ojdbc11.jar" Main




---

🧩 Folder Structure

online-quiz-system/
│
├── Main.java
├── db/
│   └── DBConnection.java
├── user/
│   ├── UserLogin.java
│   ├── UserRegister.java
│   └── QuizPanel.java
├── admin/
│   ├── AdminLogin.java
│   └── AdminDashboard.java
├── util/
│   └── Question.java
├── ojdbc11.jar
└── README.md


---

🔑 Default Credentials

Admin:

Username: admin

Password: admin123



> You can modify these in AdminLogin.java




---

📦 TODO (Optional Enhancements)

Timer-based quizzes

Password hashing

Export results to CSV

Responsive design using JavaFX



---

👨‍💻 Author

Vinay – Developer and designer of the system
Feel free to reach out for feedback or collaboration!


---

📄 License

This project is open-source for educational and personal use.
MIT License © 2025 Vinay

--

