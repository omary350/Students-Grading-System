package GUI;

import javax.swing.*;
import com.Model.admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteSubjectFromTeacher {
    public static void  deleteSubjectFromTeacherPage() {
        JFrame frame = new JFrame("Delete Subject From Teacher");
        frame.setSize(400, 400); // Set fixed size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create components
        JLabel teacherIdLabel = new JLabel("Teacher ID:");
        JTextField TeacherIdTextField = new JTextField(15);

        JLabel subjectIdLabel = new JLabel("Subject ID:");
        JTextField subjectIdTextField = new JTextField(15);

        JButton deleteSubject = new JButton("Delete Subject");

        deleteSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teacherId = TeacherIdTextField.getText();
                String subjectId = subjectIdTextField.getText();
                Boolean isTeacherIdNum = checkIfInt.isInteger(teacherId);
                Boolean isSubjectIdNum = checkIfInt.isInteger(subjectId);
                if(isTeacherIdNum && isSubjectIdNum){
                    int tID = Integer.parseInt(teacherId);
                    int sID = Integer.parseInt(subjectId);
                    admin Admin = new admin();
                    int isdeleted = Admin.deleteSubjectFromTEacher(tID,sID);
                    if(isdeleted == 1){
                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(frame, "Subject Deleted From Teacher Successfull", "Subject Assigned", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(frame, "Invalid ID, Check Both ID's and Try Again", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Invalid ID, Both ID's must be Number", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(teacherIdLabel, gbc);

        gbc.gridy = 1;
        panel.add(TeacherIdTextField, gbc);

       
        gbc.gridy = 2;
        panel.add(subjectIdLabel, gbc);

        gbc.gridy = 3;
        panel.add(subjectIdTextField, gbc);

        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(deleteSubject, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }
}
