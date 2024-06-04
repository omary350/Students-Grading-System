package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teacherMenu {
    static JFrame frame = new JFrame("Hello, Teacher!");
    public static void createTeacherMenu() {
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Set window size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create buttons
        JButton seeStudentsGradesButton = new JButton("See Students Grades");
        JButton seeStudentGradeButton = new JButton("See Student Grade");
        JButton updateStudentGradeButton = new JButton("Update Student Grade");
        JButton gradesAverageButton = new JButton("Grades Average");
        JButton mySubjectsButton = new JButton("My Subjects");
        JButton exitProgramButton = new JButton("Logout");

        // Add action listeners to buttons
         seeStudentsGradesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               studentsGradeWindow st = new studentsGradeWindow();
               st.StudentGradePage(1);
            }
         });
        seeStudentGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnterStudentIDWindow.EnterStudentIDPage();
            }
        });
        updateStudentGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateStudentGradeWindow.updateStudentPage();
            }
        });
        gradesAverageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterSubjectIdWindow.EnterSubjectIDPage(1);
            }
        });
        mySubjectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSubjectsWindow.viewSubjectPage(1);
            }
        });
        exitProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                loginPage.LoginPAge();
            }
        });

        // Set layout
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10)); // 6 rows, 1 column
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        panel.add(seeStudentsGradesButton);
        panel.add(seeStudentGradeButton);
        panel.add(updateStudentGradeButton);
        panel.add(gradesAverageButton);
        panel.add(mySubjectsButton);
        panel.add(exitProgramButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
