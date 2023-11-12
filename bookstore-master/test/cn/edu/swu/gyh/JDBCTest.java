package cn.edu.swu.gyh;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        String dburl = "jdbc:mysql://localhost:3306/bookstore";
        String dbuser = "root";
        String dbpass = "123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(dburl,dbuser,dbpass))
        {
            try(Statement statement = connection.createStatement())
            {
                String sql = "select id,name,author,price,content from book";
                try(ResultSet resultSet = statement.executeQuery(sql))
                {
                    while(resultSet.next())
                    {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String author = resultSet.getString("Author");
                        float price = resultSet.getFloat("price");
                        String content = resultSet.getNString(5);
                        System.out.println(String.format("%s, %s, %s, %s, %s",id,name,author,price,content));
                    }
                }
            }
        }


    }
}
