
package DAOs;
import com.Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class adminDAOImpl implements AdminDAO {

    @Override
    public List<teacher> getTeachers() {
         List<teacher> allTeachers = new ArrayList<>();
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("select t.teacherID , concat(t.firstName ,' ', t.LastName) as Name , s.subjectID , s.subjectName\n" + //
                                        "from teachers t\n" + //
                                        "left join teachersubjects ts on ts.teachID = t.teacherID\n" + //
                                        "left join subject s on ts.subID = s.subjectID\n" + //
                                        "order by t.teacherID asc;");
                while(rs.next()){
                    int id = rs.getInt("t.teacherID");
                    String name = rs.getString("Name");
                    int subId = rs.getInt("s.subjectID");
                    String subName = rs.getString("s.subjectName"); 
                    allTeachers.add(new teacher(id, name, subId, subName));
                }     
                     
        } catch (Exception e ) {
               System.out.println(e.getStackTrace());              
        }
        return allTeachers;
    }


    @Override
    public List<subject> getSubjects() {
        List<subject> subjects = new ArrayList<subject>();
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from subject;");
            while(rs.next()){
                int subId = rs.getInt("subjectID");
                String subName = rs.getString("subjectName");
                subjects.add(new subject(subId, subName));
            }     
                 
            } catch (Exception e ) {
                   System.out.println(e.getStackTrace());              
            }
            return subjects;

    }

    @Override
    public int addTeacher(String firstName , String lastName) {
        int rowsAffected = 0;
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            rowsAffected = stmt.executeUpdate("insert into teachers(firstName , LastName) values('"+firstName+"' , '"+lastName+"');");          
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return rowsAffected;
    }

    @Override
    public int deleteTeacher(int id) {
        int rowsAffected = 0;
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            rowsAffected = stmt.executeUpdate("delete from teachers where teacherID = "+id+";");          
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return rowsAffected;
    }

    @Override
    public int addSubject(String subName) {
        int rowsAffected = 0;
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            rowsAffected = stmt.executeUpdate("insert into subject(subjectName) values('"+subName+"');");          
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return rowsAffected;
    }

    @Override
    public int deleteSubject(int id) {
        int rowsAffected = 0;
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            rowsAffected = stmt.executeUpdate("delete from subject where subjectID = "+id+";");          
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return rowsAffected;
    }

     @Override
    public int addSubjectToTeacher(int teacherId, int subjectId) {
        int rowsAffected = 0;
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            rowsAffected = stmt.executeUpdate("insert into teachersubjects(teachID,subID) values("+teacherId+" , "+subjectId+");");          
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return rowsAffected;
    }

    @Override
    public int removeSubjectFromTeacher(int teacherId, int subjectId) {
        int rowsAffected = 0;
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            rowsAffected = stmt.executeUpdate("delete from teachersubjects where teachID = "+teacherId+" and subID = "+subjectId+";");          
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return rowsAffected;
    }


    public Boolean validateAdminID(String adminId){
        
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {           
            ResultSet rs = stmt.executeQuery("select adminId from admins where adminId = '"+adminId+"' ;");           
            if(rs.next()){
                return true;
            } 
        }catch (Exception e ) {
            System.out.println("Error happend");
            e.printStackTrace();
            
        }
        return false;
    }

    public Boolean checkIfTeacherTeachSubject(int teacherId,int subjectId){
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from teachersubjects ts where ts.teachID = "+teacherId+" and ts.subID = "+subjectId+" ");
            
            if(rs.next()){
                return true;
            } 
        }catch (Exception e ) {
            e.printStackTrace();
            
        }
        return false;

    }


    

}
