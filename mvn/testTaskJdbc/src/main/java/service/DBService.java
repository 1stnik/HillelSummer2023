package service;

import dto.Student;
import java.sql.SQLException;
import java.util.List;

public interface DBService {

    List<String> getDistinctGroups() throws SQLException;

    List<Student> getStudentsByGroup(String groupName) throws SQLException;

    List<Student> getStudentsLastNameStartWith(String letter) throws SQLException;
}
