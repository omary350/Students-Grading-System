
package DAOs;
import com.Model.*;
import java.util.List;

public interface AdminDAO {
    List<teacher> getTeachers();
    List<subject> getSubjects();
    int addTeacher(String firstName , String lastName);
    int deleteTeacher(int id);
    int addSubject(String subName);
    int deleteSubject(int id);
    int addSubjectToTeacher(int teacherId , int subjectId);
    int removeSubjectFromTeacher(int teacherId , int subjectId);
}
