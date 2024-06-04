package GUI;

import javax.swing.*;
import com.Model.teacher;
import DAOs.teacherDAOImpl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudentGradeWindow {    
    public static void updateStudentPage() {
        JFrame frame = new JFrame("Update Student Grade");
        frame.setSize(400, 400); // Set fixed size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create components
        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdTextField = new JTextField(15);

        JLabel subjectIdLabel = new JLabel("Subject ID:");
        JTextField subjectIdTextField = new JTextField(15);

        JLabel newGradeLabel = new JLabel("New Grade:");
        JTextField newGradeTextField = new JTextField(15);

        JButton updateGradeButton = new JButton("Update Grade");

        updateGradeButton.addActionListener(new ActionListener() {
            teacher Teacher = new teacher();
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                String studentId = studentIdTextField.getText();
                boolean ifStudentIdInt = checkIfInt.isInteger(studentId);
                String subjectId = subjectIdTextField.getText();
                boolean ifSubjectIdInt = checkIfInt.isInteger(subjectId);
                String grade = newGradeTextField.getText();
                Boolean ifgradeDouble = checkIfInt.isDouble(grade);
                if(ifStudentIdInt & ifSubjectIdInt & ifgradeDouble){
                    int stId = Integer.parseInt(studentId);
                    int suId = Integer.parseInt(subjectId);
                    Double gr = Double.parseDouble(grade);
                    Boolean ifTeacherTeachSubject = teacherDAOImpl.checkIfTeacherTeachSubject(suId);
                    Boolean ifStudentStudySubject = teacherDAOImpl.checkIfStudentLearnSubject(stId,suId);
                    if(ifTeacherTeachSubject & ifStudentStudySubject){
                       Boolean isUpdated =  Teacher.updateStudent(stId,suId ,gr);
                       if(isUpdated){
                        JOptionPane.showMessageDialog(frame, "Grade Updated Succesfully", "Update Message", JOptionPane.INFORMATION_MESSAGE);
                       }else{
                        JOptionPane.showMessageDialog(frame, "Operation Falied, Check input info", "", JOptionPane.ERROR_MESSAGE);
                       }
                    }else{
                        JOptionPane.showMessageDialog(frame, "Unauthorized to change this Student", "Authorization Message", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Invalid input ID's must be Number", "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(studentIdLabel, gbc);

        gbc.gridy = 1;
        panel.add(studentIdTextField, gbc);

       
        gbc.gridy = 2;
        panel.add(subjectIdLabel, gbc);

        gbc.gridy = 3;
        panel.add(subjectIdTextField, gbc);

       
        gbc.gridy = 4;
        panel.add(newGradeLabel, gbc);
        gbc.gridy = 5;
        panel.add(newGradeTextField, gbc);

        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(updateGradeButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }
}
