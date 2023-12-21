package cn.edu.swu.gyh.db;

import java.sql.ResultSet;

public interface ResultSetVisitor {
    public void visit(ResultSet resultSet);
}
