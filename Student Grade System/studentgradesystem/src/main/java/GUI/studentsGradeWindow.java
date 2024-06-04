package GUI;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Model.student;
import com.Model.teacher;
import java.awt.*;

public class studentsGradeWindow {
  
     teacher Teacher;
     DefaultTableModel tableModel ;
     public studentsGradeWindow(){
        this.Teacher = new teacher();
        this.tableModel = new DefaultTableModel();
     }
    public void StudentGradePage(int ... args){
        JFrame frame = new JFrame("Students Grades List");
        frame.setSize(600, 400);

       // Center the window on the screen
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       int centerX = (screenSize.width - frame.getWidth()) / 2;
       int centerY = (screenSize.height - frame.getHeight()) / 2;
       frame.setLocation(centerX, centerY);

        // Create table model
        
        //DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Subject");
        tableModel.addColumn("Grade");
       
        // add content to table
        if(args[0] == 1){
            showStudents();
        }else if(args[0] == 2){
            showStudent(args[1]);
        }

        // Create JTable
        JTable studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Add table to the frame
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public  void showStudents(){
        tableModel.setRowCount(0);
        List<student> students = Teacher.printStudents();
        for (student Student : students) {
            tableModel.addRow(new Object[]{Student.studentId, Student.studentName, Student.sub.subjectName, Student.grade.grade});           
        }
       
    }

    public  void showStudent(int studentid){
        tableModel.setRowCount(0);
        List<student> students = Teacher.printStudent(studentid);
        for (student Student : students) {
            tableModel.addRow(new Object[]{Student.studentId, Student.studentName, Student.sub.subjectName, Student.grade.grade});           
        }     
    }
}
