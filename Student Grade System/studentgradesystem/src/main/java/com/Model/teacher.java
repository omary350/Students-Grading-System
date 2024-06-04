package com.Model;
import DAOs.*;

import java.util.List;

public class teacher {
    public int teacherId;
    public String teacherName;
    public teacherDAOImpl callMethod;
    public subject Subject;
    

    public teacher(){
        this .callMethod = new teacherDAOImpl();
    }

    public teacher(int teacherId , String teacherName, int subId , String subName){
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this .callMethod = new teacherDAOImpl();
        this.Subject = new subject(subId, subName);
        
    }
    

    public  List<student>  printStudents(){
        List<student> allStudent = callMethod.getStudentsForTeacher();
        return allStudent;     
    }

    public  List<student> printStudent(int studentId){   
            List<student> allStudent = callMethod.getStudent(studentId);
            return allStudent;
    }

    public Boolean updateStudent(int sId , int suId , double grade){  
           int ifUpdated =  callMethod.updateStudentGrade(sId ,suId , grade);
           if(ifUpdated == 1){
            return true;
           }else{
            return false;
           }
    }

    public double gradeAverage(int subjectId){
            List<Grades> grades = callMethod.getGrades(subjectId);
            double averge = 0;
             for (Grades grades2 : grades) {
                 averge = averge + grades2.grade;
             }
          return averge / grades.size();
    }

    public List<subject> subjectsForTeacher(){
        List<subject> subs  = callMethod.getSubjectIdForTeacher();
        return subs;
    }

}
