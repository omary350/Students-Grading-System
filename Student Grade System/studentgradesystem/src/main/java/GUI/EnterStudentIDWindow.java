package GUI;

import javax.swing.*;

import DAOs.teacherDAOImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterStudentIDWindow {
     public static void EnterStudentIDPage() {
        JFrame frame = new JFrame("Enter Student ID");
        frame.setSize(400, 200); // Set window size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create components
        JLabel idLabel = new JLabel("Enter Student ID:");
        JTextField idTextField = new JTextField(15); // Initial width
        JButton showButton = new JButton("Show");

        //Show button ActionListener
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idTextField.getText();
                boolean ifInt =checkIfInt.isInteger(studentId);
                if(ifInt){
                    int id = Integer.parseInt(studentId);
                    boolean ifExist = teacherDAOImpl.validateStudentId(id);
                    if(ifExist){
                        frame.setVisible(false);
                        studentsGradeWindow st = new studentsGradeWindow();
                        st.StudentGradePage(2,id);
                    }else{
                        JOptionPane.showMessageDialog(frame, "Invalid Student ID", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Invalid Student ID", "Invalid ID", JOptionPane.ERROR_MESSAGE);
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
