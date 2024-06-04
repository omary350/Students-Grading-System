package GUI;

import javax.swing.*;

import com.Model.admin;
import com.Model.teacher;
import DAOs.teacherDAOImpl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class enterSubjectIdWindow {
     public static void EnterSubjectIDPage(int whichOption) {
        JFrame frame = new JFrame("Enter Subject ID");
        frame.setSize(400, 200); // Set window size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create components
        JLabel idLabel = new JLabel("Enter Subject ID:");
        JTextField idTextField = new JTextField(15); // Initial width
        JButton showButton;
        if(whichOption == 1 ){
             showButton = new JButton("Show Average");
        }else{
             showButton = new JButton("Delete Subject");
        }
        
       

        //Show button ActionListener
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subjectId = idTextField.getText();
                boolean ifInt =checkIfInt.isInteger(subjectId);
                if(ifInt){
                    int id = Integer.parseInt(subjectId);
                    if(whichOption == 1){
                        boolean ifExist = teacherDAOImpl.checkIfTeacherTeachSubject(id);
                        if(ifExist){
                            teacher Teacher = new teacher();
                            double averge =   Teacher.gradeAverage(id);
                            JOptionPane.showMessageDialog(frame, "Average Grades = "+averge, "Grades Average", JOptionPane.INFORMATION_MESSAGE);
                            
                        }else{
                            JOptionPane.showMessageDialog(frame, "Invalid subject ID", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        admin Admin = new admin();
                        int isDeleted = Admin.deleteSubject(id);
                        if(isDeleted == 1){
                            JOptionPane.showMessageDialog(frame, "Subject Deleted Successfully", "Delete Subject", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(frame, "Please Check Subject ID and Try Again", "Try Again", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Invalid ID, ID must be Number", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                }
                
                

            }
        });
        
        // Set layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        gbc.gridy = 1;
        panel.add(idTextField, gbc);

        gbc.gridy = 2;
        panel.add(showButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

}
