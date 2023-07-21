package dbQuery;

import config.DBConnectivity;
import dto.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import mapper.Mapper;

public class DBQuery {

    private final String SQL_DISTINCT_GROUP = "select distinct stady_group from student order by stady_group";
    private final String SQL_GET_GROUP_STUDENTS = "select * from student where stady_group = '%s' order by last_name";
    private final String SQL_GET_STUDENTS_LAST_NAME_START_WITH = "select * from student s where s.last_name like '%s';";

    public List<String> getDistinctGroups() throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_DISTINCT_GROUP);
        List<String> result = Mapper.getGroupFromResultSet(resultSet);
        DBConnectivity.closeConnection();
        return result;
    }

    public List<Student> getListStudentsByGroup(String groupNumber) throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format(SQL_GET_GROUP_STUDENTS, groupNumber));
        List<Student> result = Mapper.getStudentsByGroupFromResultSet(resultSet);
        DBConnectivity.closeConnection();
        return result;
    }

        public List<Student> getListStudentsLastNameStartWith(String startLetter) throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format(SQL_GET_STUDENTS_LAST_NAME_START_WITH, startLetter + "%"));
        List<Student> result = Mapper.getStudentsByGroupFromResultSet(resultSet);
        DBConnectivity.closeConnection();
        return result;
    }
}
