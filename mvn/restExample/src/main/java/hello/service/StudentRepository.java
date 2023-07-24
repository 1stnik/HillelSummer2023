package hello.service;

import com.mysql.cj.jdbc.MysqlDataSource;
import hello.dto.Student;
import hello.dto.StudentCreate;
import hello.dto.StudentDto;
import hello.exceptions.UserNotFoundExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public static final String serverTimeZone = "UTC";
    public static final String serverName = "localhost"; // ip address db
    public static final String databaseName = "hillel"; // bd name
    public static final int portNumber = 3306; // db port
    public static final String user = "root"; // login
    public static final String password = "rootroot"; // password

    private Connection getConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPortNumber(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        return dataSource.getConnection();
    }

    public List<StudentDto> getStudents() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from student");

        List<StudentDto> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            student.add(new StudentDto(id, firstName, lastName));
        }
        connection.close();
        return student;
    }


    public StudentDto getStudent(int id) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String SQL = "select * from student where id = " + id;
        ResultSet rs = statement.executeQuery(SQL);

        List<StudentDto> student = new ArrayList<>();
        while (rs.next()) {
            int i = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            student.add(new StudentDto(i, firstName, lastName));
        }
        connection.close();

        if (student.isEmpty()) {
            throw new UserNotFoundExeption(String.valueOf(id));
        } else {
            return student.get(0);
        }
    }

    public void createUser(StudentCreate student) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String SQL = "insert into  student (first_name, last_name) value  ('%s', '%s')";
        statement.execute(String.format(SQL, student.getFirstName(), student.getLastName()));
        connection.close();

    }

    public void updateStudent(StudentDto student) throws SQLException {
        /*
        UPDATE table_name
        SET column1 = value1, column2 = value2, ...
        WHERE condition;
         */

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String SQL = "UPDATE student SET first_name = '%s', last_name = '%s' WHERE id = %s";
        statement.execute(String.format(SQL, student.getFirstName(), student.getLastName(), student.getId()));
        connection.close();

    }
    public void deleteStudent(int id) throws SQLException {
        /*
        UPDATE table_name
        SET column1 = value1, column2 = value2, ...
        WHERE condition;
         */

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String SQL = "DELETE FROM student WHERE id = %s;";
        statement.execute(String.format(SQL, id));
        connection.close();

    }


}
