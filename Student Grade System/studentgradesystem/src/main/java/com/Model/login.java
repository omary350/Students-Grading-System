package com.Model;
import DAOs.*;

public class login {
    
    teacherDAOImpl tDaoImpl;
    adminDAOImpl aDaoImpl;
    public login(){
        this.tDaoImpl = new teacherDAOImpl();
        this.aDaoImpl = new adminDAOImpl();
    }

    public int LoginTeacher(String id){
       Boolean isInt = isInteger(id);
            if(isInt){
                currentTeacherId.currentId = Integer.parseInt(id);
                Boolean ifExist = teacherDAOImpl.validateTeacherId(currentTeacherId.currentId);
                if(ifExist){
                   return 1;
                }
            }else if(!isInt){               
                Boolean ifExist = aDaoImpl.validateAdminID(id);               
                if(ifExist){
                       return 2;
                }
            }
            return 3;
    }



    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
