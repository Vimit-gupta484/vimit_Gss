package connection.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utilityconnection {
    public static Connection getConnection() throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gssproject","root","Password@123");
        return con;
    }

}
