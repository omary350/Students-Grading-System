package com.Model;
import DAOs.*;

import java.util.List;

public class admin {
   protected String id;
   protected String name;
   protected adminDAOImpl adminImpl;
   protected teacherDAOImpl tDaoImpl;
   

    public admin(){
        this.adminImpl = new adminDAOImpl();
        this.tDaoImpl = new teacherDAOImpl();
    }
    public admin(String id , String name){
        this.id = id;
        this.name = name;
        this.adminImpl = new adminDAOImpl();
        this.tDaoImpl = new teacherDAOImpl();
    }

    public  List<teacher> allTeachers(){
        List<teacher> teachers = adminImpl.getTeachers();
        return teachers;
    }

    public List<subject> viewSubjects(){
        List<subject> subjects = adminImpl.getSubjects();
       return subjects;
    }

    public int addTeacher(String firstName , String lastName){ 
        int isInserted = adminImpl.addTeacher(firstName, lastName);
        return isInserted;
    }

    public int deleteTeacher(int teacherId){
        int isDeleted = adminImpl.deleteTeacher(teacherId);
        return isDeleted;
    }

    public int addSubject(String Name){
        int isInserted = adminImpl.addSubject(Name);
       return isInserted;
    }


    public int deleteSubject(int id){
        int isDeleted = adminImpl.deleteSubject(id);
        return isDeleted;
    }

    public int addSubjectToTEacher(int tId , int sId){
        int isAdded = adminImpl.addSubjectToTeacher(tId, sId);
        return isAdded;
    }

    public int deleteSubjectFromTEacher(int tId , int sId){
        int isDeleted = adminImpl.removeSubjectFromTeacher(tId, sId);
        return isDeleted;
    }

}
