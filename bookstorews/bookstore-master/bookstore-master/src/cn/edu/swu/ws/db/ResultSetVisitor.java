package cn.edu.swu.ws.db;

import java.sql.ResultSet;

public interface ResultSetVisitor {
    public void visit(ResultSet resultSet);
}
