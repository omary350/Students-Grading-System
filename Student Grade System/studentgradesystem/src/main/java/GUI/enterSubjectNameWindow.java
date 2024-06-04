package GUI;

import javax.swing.*;
import com.Model.admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class enterSubjectNameWindow {
         public static void EnterSubjectNameWindow() {
        JFrame frame = new JFrame("Add Subject ");
        frame.setSize(400, 200); // Set window size

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create components
        JLabel nameLabel = new JLabel("Enter Subject Name:");
        JTextField nameTextField = new JTextField(15); // Initial width
        JButton addButton = new JButton("Add Subject");

        //Show button ActionListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin Admin = new admin();
                String name = nameTextField.getText();
                    int ifAdded = Admin.addSubject(name);
                    if(ifAdded == 1){
                        JOptionPane.showMessageDialog(frame, "Subject Added Successfully", "Teacher Added", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(frame, "Please Try Again", "Try Again", JOptionPane.ERROR_MESSAGE);
                    }
             
               
            }
        });
        
        // Set layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridy = 1;
        panel.add(nameTextField, gbc);

        gbc.gridy = 2;
        panel.add(addButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }
}
