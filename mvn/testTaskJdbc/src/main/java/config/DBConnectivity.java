package config;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectivity {

    private static Connection connection;

    public static final String serverTimeZone = "UTC";
    public static final String serverName = "localhost"; // ip address db
    public static final String databaseName ="testTask"; // bd name
    public static final int portNumber = 3306; // db port
    public static final String user = "root"; // login
    public static final String password = "rootroot"; // password

    public static Connection getConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUseSSL( false );
        dataSource.setServerTimezone( serverTimeZone );
        dataSource.setServerName( serverName );
        dataSource.setDatabaseName( databaseName );
        dataSource.setPortNumber( portNumber );
        dataSource.setUser( user );
        dataSource.setPassword( password );

        return connection =  dataSource.getConnection();
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
