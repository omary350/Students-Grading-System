package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminWindow {
    public static void adminPage() {
        JFrame frame = new JFrame("Hello, Admin!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500); // Set window size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create buttons
        JButton viewTeachersButton = new JButton("View Teachers");
        JButton viewSubjectsButton = new JButton("View Subjects");
        JButton addTeacherButton = new JButton("Add Teacher");
        JButton deleteTeacherButton = new JButton("Delete Teacher");
        JButton addSubjectButton = new JButton("Add Subject");
        JButton deleteSubjectButton = new JButton("Delete Subject");
        JButton addSubjectToTeacherButton = new JButton("Add Subject to Teacher");
        JButton removeSubjectFromTeacherButton = new JButton("Remove Subject from Teacher");
        JButton exitProgramButton = new JButton("Logout");

        // Add action listeners to buttons
        viewTeachersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTeachersPage.viewTeachersList();
            }
        });

        viewSubjectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSubjectsWindow.viewSubjectPage(2);
            }
        });

        addTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterTeacherNameWindow.EnterTeacherNameWindow();
                
            }
        });
        deleteTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnterTeacherIdWindow.EnterTeacherIDPage();
                
            }
        });
        addSubjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterSubjectNameWindow.EnterSubjectNameWindow();
                
            }
        });
        deleteSubjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterSubjectIdWindow.EnterSubjectIDPage(2);
                
            }
        });
        addSubjectToTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSubjectToTeacherWindow.addSubjectToTeacherPage();
                
            }
        });
        removeSubjectFromTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSubjectFromTeacher.deleteSubjectFromTeacherPage();              
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
        JPanel panel = new JPanel(new GridLayout(9, 1, 10, 10)); // 9 rows, 1 column
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        panel.add(viewTeachersButton);
        panel.add(viewSubjectsButton);
        panel.add(addTeacherButton);
        panel.add(deleteTeacherButton);
        panel.add(addSubjectButton);
        panel.add(deleteSubjectButton);
        panel.add(addSubjectToTeacherButton);
        panel.add(removeSubjectFromTeacherButton);
        panel.add(exitProgramButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    
}
