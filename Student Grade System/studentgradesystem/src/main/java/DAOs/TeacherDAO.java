
package DAOs;
import com.Model.*;

import java.util.*;

public interface TeacherDAO {
    List<student> getStudentsForTeacher();
    List<student> getStudent(int studentId);
    int updateStudentGrade(int studentId, int subjectId,double Grade);
    List<Grades> getGrades(int subjectId);
    List<subject> getSubjectIdForTeacher();
    
}
