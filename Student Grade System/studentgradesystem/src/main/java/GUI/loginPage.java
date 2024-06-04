package GUI;

import javax.swing.*;

import com.Model.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class loginPage {
    static login loginFunctionCall = new login();

    public static void LoginPAge() {
        JFrame frame = new JFrame("Student Grade System - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300); // Set fixed size
        frame.setResizable(false); // Prevent resizing

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        // Create components
        JLabel headerLabel = new JLabel("Student Grade System");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Customize font

        JLabel idLabel = new JLabel("Enter your ID:");
        JTextField idTextField = new JTextField(20); // Initial width
        JButton loginButton = new JButton("Login");

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredId = idTextField.getText();
                int whichUser = loginFunctionCall.LoginTeacher(enteredId);
                if(whichUser == 1){
                    frame.setVisible(false);
                    teacherMenu.createTeacherMenu();
                }else if(whichUser == 2){
                    frame.setVisible(false);
                    adminWindow.adminPage();
                }else{
                    JOptionPane.showMessageDialog(frame, "Invalid ID. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(headerLabel, gbc);

        gbc.gridy = 1;
        panel.add(idLabel, gbc);

        gbc.gridy = 2;
        panel.add(idTextField, gbc);

        gbc.gridy = 3;
        panel.add(loginButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }
}
