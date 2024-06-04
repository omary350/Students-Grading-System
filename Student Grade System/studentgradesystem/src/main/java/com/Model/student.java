package com.Model;

public class student {
    public int studentId;
    public String studentName;
    public Grades grade;
    public subject sub;



    public student(int studentId , String studentName , int Grade , String subjectName){
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = new Grades(Grade);
        this.sub = new subject(subjectName);
    }

    
}
