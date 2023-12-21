package cn.edu.swu.gyh;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String dbUrl = "jdbc:mysql://localhost:3306/bookstore";
//        String dbUser = "root";
//        String dbPass = "qwer1234";
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
//            try (Statement statement = connection.createStatement()) {
//                String sql = "select id,name,author,price,content from book";
//                try(ResultSet resultSet = statement.executeQuery(sql) ){
//                    while (resultSet.next()) {
//                        int id = resultSet.getInt("id");
//                        String name = resultSet.getString("name");
//                        String author = resultSet.getString("Author");
//                        float price = resultSet.getFloat("price");
//                        String content = resultSet.getString(5);
//
//                        System.out.println(String.format("%s, %s, %s, %s, %s", id, name, author, price, content));
//                    }
//                }
//            }
//        }

        String template = "select * from book where name like '%%%s%%'";
        System.out.println(String.format(template, "中国"));
    }



}
