package mapper;

import dto.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<String> getGroupFromResultSet(ResultSet resultSet) throws SQLException {
        List<String> groups = new ArrayList<>();
        while (resultSet.next()) {
            groups.add(resultSet.getString(1));
        }
        return groups;
    }

    public static List<Student> getStudentsByGroupFromResultSet(ResultSet resultSet)
            throws SQLException {
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(new Student()
                    .setId(resultSet.getInt(1))
                    .setLastName(resultSet.getString("last_name"))
                    .setFirstName(resultSet.getString("first_name"))
                    .setEmail(resultSet.getString("email"))
                    .setDateOfBirth(resultSet.getDate("date_of_birth"))
                    .setGroup(resultSet.getString("stady_group"))
                    .setCountry(resultSet.getString("country"))
            );
        }
        return students;
    }
}
