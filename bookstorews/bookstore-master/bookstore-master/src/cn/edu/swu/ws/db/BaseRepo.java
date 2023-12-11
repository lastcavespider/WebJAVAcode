package cn.edu.swu.ws.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public abstract class BaseRepo {
    private static BasicDataSource dataSource;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/bookstore");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(7);
            dataSource.setMaxTotal(20);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected BaseRepo() {
    }

    public Connection getDBConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 执行insert, update, delete语句
    protected boolean execute(String cudSQL) throws SQLException {
        System.out.println(cudSQL);
        try(Connection connection = dataSource.getConnection()) {
            try(Statement statement = connection.createStatement()){
                return statement.execute(cudSQL);
            }
        }
    }

    // 提供一个执行查询的帮助接口
    protected void query(String sql, ResultSetVisitor visitor) throws SQLException {
        System.out.println(sql);
        try(Connection connection = dataSource.getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        visitor.visit(resultSet);
                    }
                }
            }
        }
    }
}
