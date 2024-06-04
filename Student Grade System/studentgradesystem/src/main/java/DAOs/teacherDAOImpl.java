package DAOs;
import com.Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class teacherDAOImpl  implements TeacherDAO {
     @Override
    public List<student> getStudentsForTeacher() {
        List<student> allStudent = new ArrayList<>();
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("select s.StudentID, s.studentName , su.subjectName , sg.Grade\n" + //
                                        "from students s \n" + //
                                        "join studentsubjects ss on ss.student_ID = s.StudentID\n" + //
                                        "join subject su on ss.subject_ID = su.subjectID\n" + //
                                        "join studentsgrade sg on s.StudentID = sg.studID and su.subjectID = sg.subID\n" + //
                                        "join teachersubjects ts on su.subjectID = ts.subID\n" + //
                                        "where ts.teachID = "+currentTeacherId.currentId+"\n" + //
                                        "order by su.subjectName , sg.Grade desc;");
                while(rs.next()){
                    int id = rs.getInt("studentID");
                    String name = rs.getString("studentName");
                    String subjectName = rs.getString("subjectName");
                    int grade = rs.getInt("Grade");
                    allStudent.add(new student(id, name, grade , subjectName));
                }     
                     
        } catch (Exception e ) {
               System.out.println(e.getStackTrace());
               
        }
        return allStudent;
       
    }


     @Override
    public List<student> getStudent(int studentId) {
        List<student> allStudent = new ArrayList<>();
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select s.StudentID, s.studentName , su.subjectName , sg.Grade\n" + //
                                "from students s \n" + //
                                "join studentsubjects ss on ss.student_ID = s.StudentID\n" + //
                                "join subject su on ss.subject_ID = su.subjectID\n" + //
                                "join studentsgrade sg on s.StudentID = sg.studID and su.subjectID = sg.subID\n" + //
                                "join teachersubjects ts on su.subjectID = ts.subID\n" + //
                                "where ts.teachID = "+currentTeacherId.currentId+" and sg.studID = "+studentId+"\n" + //
                                "order by s.StudentID ; ");
                                while(rs.next()){
                                    int id = rs.getInt("studentID");
                                    String name = rs.getString("studentName");
                                    String subjectName = rs.getString("subjectName");
                                    int grade = rs.getInt("Grade");
                                    allStudent.add(new student(id, name, grade , subjectName));
                                }   
           
           

        }catch (Exception e ) {
           e.printStackTrace();
            
        }
        return allStudent;
    }

     @Override
    public int updateStudentGrade(int studentId, int subjectId,double Grade) {
        int rowsAffected = 0;
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            rowsAffected = stmt.executeUpdate("update studentsgrade sg \n" + //
                                "set Grade = "+Grade+" where sg.studID = "+studentId+" and subID = "+subjectId+";");
            
           
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return rowsAffected;
    }

    public List<Grades> getGrades(int subjectId){
        List<Grades> grades = new ArrayList<>();
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("select   sg.Grade \n" + //
                                        "from studentsgrade sg\n" + //
                                        "join teachersubjects ts on sg.subID = ts.subID\n" + //
                                        "where ts.teachID = "+currentTeacherId.currentId+" and sg.subID = "+subjectId+"\n" + //
                                        "order by  sg.Grade ;");
                while(rs.next()){
                    int grade = rs.getInt("sg.Grade");
                    grades.add(new Grades(grade));
                }     
                     
        }catch (Exception e ) {
               System.out.println(e.getStackTrace());
               
        }
        return grades;
    }

    public List<subject> getSubjectIdForTeacher(){
        List<subject> sub = new ArrayList<subject>();
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select su.subjectID , su.subjectName \n" + //
                                "from subject su \n" + //
                                "join teachersubjects ts on ts.subID = su.subjectID\n" + //
                                "where ts.teachID = "+currentTeacherId.currentId+";");
            while(rs.next()){
                int subId = rs.getInt("su.subjectID");
                String subName = rs.getString("su.subjectName");
                sub.add(new subject(subId, subName));
            }     
                 
    } catch (Exception e ) {
           System.out.println(e.getStackTrace());
           
    }
    return sub;

    }

    

   

    public static Boolean validateTeacherId(int TeacherId){
        
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select teacherID from teachers where teacherID = "+TeacherId+" ");
            
            if(rs.next()){
                return true;
            } 
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return false;
    }
    

    public static Boolean validateStudentId(int studentId){
        
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select StudentID from students where StudentID = "+studentId+" ");
            
            if(rs.next()){
                return true;
            } 
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return false;
    }

    public static Boolean validateSubjectId(int subjectId){
        
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select subjectID from subject where subjectID = "+subjectId+" ");
            
            if(rs.next()){
                return true;
            } 
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return false;
    }

    public static  Boolean checkIfTeacherTeachSubject(int subjectId){
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from teachersubjects ts where ts.teachID = "+currentTeacherId.currentId+" and ts.subID = "+subjectId+" ");
            
            if(rs.next()){
                return true;
            } 
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return false;

    }

    public static Boolean checkIfStudentLearnSubject(int studentId , int subjectId){
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from studentsubjects ss where ss.student_ID = "+studentId+" and ss.subject_ID = "+subjectId+"; ");
            
            if(rs.next()){
                return true;
            } 
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return false;

    }
    
}
