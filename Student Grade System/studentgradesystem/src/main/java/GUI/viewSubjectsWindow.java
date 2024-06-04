package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Model.admin;
import com.Model.subject;
import com.Model.teacher;
import java.awt.*;
import java.util.List;

public class viewSubjectsWindow {
    public static void viewSubjectPage(int teacherORadmin) {
        JFrame frame = new JFrame("Subjects List");
        frame.setSize(600, 400);

         // Center the window on the screen
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       int centerX = (screenSize.width - frame.getWidth()) / 2;
       int centerY = (screenSize.height - frame.getHeight()) / 2;
       frame.setLocation(centerX, centerY);


        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Subject ID");
        tableModel.addColumn("Subject Name");

        // Populate table model with student data
        if(teacherORadmin == 1){
          tableModel.setRowCount(0);
          teacher Teacher = new teacher();
           List<subject> subjects =  Teacher.subjectsForTeacher();
           for (subject subject : subjects) {
               tableModel.addRow(new Object[]{subject.subjectId, subject.subjectName});
            }
        }else{
          tableModel.setRowCount(0);
          admin Admin = new admin();
          List<subject> subjects = Admin.viewSubjects();
          for (subject subject : subjects) {
            tableModel.addRow(new Object[]{subject.subjectId, subject.subjectName});
         }
        }
        
       

        // Create JTable
        JTable studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Add table to the frame
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
