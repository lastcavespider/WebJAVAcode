package cn.edu.swu.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTool {

    public static Connection getDBConnection()
    {
        String dburl = "jdbc:mysql://localhost:3306/bookstore";
        String dbuser = "root";
        String dbpass = "123456";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl,dbuser,dbpass);
            return connection;
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


    }
}
