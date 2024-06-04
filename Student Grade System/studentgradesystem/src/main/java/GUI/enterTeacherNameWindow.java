package GUI;

import javax.swing.*;
import com.Model.admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class enterTeacherNameWindow {
    public static void EnterTeacherNameWindow() {
        JFrame frame = new JFrame("Enter Teacher Name");
        frame.setSize(400, 300); // Set window size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create components
        JLabel fnameLabel = new JLabel("Enter Teacher First Name:");
        JLabel lnameLabel = new JLabel("Enter Teacher Last Name:");
        JTextField fnameTextField = new JTextField(15); // Initial width
        JTextField lnameTextField = new JTextField(15); // Initial width
        JButton addButton = new JButton("Add Teacher");

        //Show button ActionListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin Admin = new admin();
                String fname = fnameTextField.getText();
                String lname = lnameTextField.getText();
                boolean fnameAllLetters = fname.chars().allMatch(Character::isLetter);
                boolean LnameAllLetters = lname.chars().allMatch(Character::isLetter);
                if(fnameAllLetters && LnameAllLetters){
                    int ifAdded = Admin.addTeacher(fname,lname);
                    if(ifAdded == 1){
                        JOptionPane.showMessageDialog(frame, "Teacher Added Successfully", "Teacher Added", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(frame, "Please Try Again", "Try Again", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, " please Put Valid Name", "Invalid Teacher Name", JOptionPane.ERROR_MESSAGE);
                }
               
            }
        });
        
        // Set layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(fnameLabel, gbc);

        gbc.gridy = 1;
        panel.add(fnameTextField, gbc);

        gbc.gridy = 2;
        panel.add(lnameLabel , gbc);

        gbc.gridy = 3;
        panel.add(lnameTextField, gbc);

        gbc.gridy = 4;
        panel.add(addButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

}
