package cn.edu.swu.ws;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {

        try(Connection connection = DBTool.getDBConnection())
        {
            try(Statement statement = connection.createStatement())
            {
                String sql = "select id,name,author,price,content from book";
                try(ResultSet resultSet = statement.executeQuery(sql))
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<table>");
                    sb.append("<tr><th>ID</th><th>书名</th><th>作者</th><th>价格</th><th>内容</th></tr>");
                    while(resultSet.next())
                    {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String author = resultSet.getString("Author");
                        float price = resultSet.getFloat("price");
                        String content = resultSet.getNString(5);

                        sb.append(String.format(
                                "<tr><th>%s</th><th>%s</th><th>%s</th><th>%s</th><th>%s</th></tr>",
                                id,name,author,price,content)
                        );
                    }
                    sb.append("</table>");


                    response.setContentType("text/html");
                    try(Writer writer =response.getWriter() )
                    {
                        writer.write(sb.toString());
                    }

                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
