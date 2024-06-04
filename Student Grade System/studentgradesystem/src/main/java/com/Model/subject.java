package com.Model;

public class subject {
    public int subjectId;
    public String subjectName;

    
    public subject(String subjectName){
        this.subjectName = subjectName;
    }
    public subject(int subjectId , String subjectName){
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
}
