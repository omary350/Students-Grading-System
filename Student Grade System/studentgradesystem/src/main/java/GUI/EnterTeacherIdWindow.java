package GUI;
import javax.swing.*;

import com.Model.admin;
import DAOs.teacherDAOImpl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EnterTeacherIdWindow {
        public static void EnterTeacherIDPage() {
        JFrame frame = new JFrame("Enter Teacher ID");
        frame.setSize(400, 200); // Set window size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create components
        JLabel idLabel = new JLabel("Enter Teacher ID:");
        JTextField idTextField = new JTextField(15); // Initial width
        JButton deleteButton = new JButton("Delete Teacher");

        //Show button ActionListener
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TeacherId = idTextField.getText();
                boolean ifInt =checkIfInt.isInteger(TeacherId);
                if(ifInt){
                    int id = Integer.parseInt(TeacherId);
                    boolean ifExist = teacherDAOImpl.validateTeacherId(id);
                    if(ifExist){
                         admin Admin = new admin();
                        int isDeleted =  Admin.deleteTeacher(id);
                        if(isDeleted == 1){
                            JOptionPane.showMessageDialog(frame, "Teacher Deleted successfully", "Delete Teacher", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                        JOptionPane.showMessageDialog(frame, "Please Check ID Again", "Delete Falied", JOptionPane.ERROR_MESSAGE);
                       }
                    }else{
                        JOptionPane.showMessageDialog(frame, "Invalid Tacher ID", "Invalid ID", JOptionPane.ERROR_MESSAGE);
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
        panel.add(deleteButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }
}
