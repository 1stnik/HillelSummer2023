package service.impl;

import dbQuery.DBQuery;
import dto.Student;
import java.sql.SQLException;
import java.util.List;
import service.DBService;

public class DBServiceImpl implements DBService {

    @Override
    public List<String> getDistinctGroups() throws SQLException {
        DBQuery dbQuery = new DBQuery();
        return dbQuery.getDistinctGroups();
    }

    @Override
    public List<Student> getStudentsByGroup(String groupName) throws SQLException {
        DBQuery dbQuery = new DBQuery();
        return dbQuery.getListStudentsByGroup(groupName);
    }

    @Override
    public List<Student> getStudentsLastNameStartWith(String letter) throws SQLException {
        DBQuery dbQuery = new DBQuery();
        return dbQuery.getListStudentsLastNameStartWith(letter);
    }
}
