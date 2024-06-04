package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Model.admin;
import com.Model.teacher;
import java.awt.*;
import java.util.List;

public class viewTeachersPage {
    public static void viewTeachersList() {
        JFrame frame = new JFrame("Teaechers List");
        frame.setSize(600, 200);

         // Center the window on the screen
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       int centerX = (screenSize.width - frame.getWidth()) / 2;
       int centerY = (screenSize.height - frame.getHeight()) / 2;
       frame.setLocation(centerX, centerY);


        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Teacher ID");
        tableModel.addColumn("Teacher Name");
        tableModel.addColumn("Subject ID");
        tableModel.addColumn("Subject Name");

        // Populate table model with student data
        admin admin = new admin();
        List<teacher> teachers =  admin.allTeachers();
         for (teacher teacher : teachers) {
            tableModel.addRow(new Object[]{teacher.teacherId,teacher.teacherName,teacher.Subject.subjectId, teacher.Subject.subjectName});
        }
       

        // Create JTable
        JTable studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

      
        
        // Add table to the frame
        frame.add(scrollPane, BorderLayout.CENTER);

    
        frame.setVisible(true);
    }
}
