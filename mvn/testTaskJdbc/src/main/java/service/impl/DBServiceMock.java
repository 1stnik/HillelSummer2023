package service.impl;

import dbQuery.DBQuery;
import dto.Student;
import java.sql.SQLException;
import java.util.List;
import service.DBService;

public class DBServiceMock implements DBService {

    @Override
    public List<String> getDistinctGroups() throws SQLException {
        return List.of("GR-1","GR-2","GR-3" );
    }

    @Override
    public List<Student> getStudentsByGroup(String groupName) throws SQLException {
        return List.of(new Student().setId(1).setFirstName("Alex").setLastName("Stepurko"));
    }

    @Override
    public List<Student> getStudentsLastNameStartWith(String letter) {
        return null;
    }
}
