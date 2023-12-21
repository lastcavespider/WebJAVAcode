package cn.edu.swu.gyh.book;

import cn.edu.swu.gyh.common.PageTool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/search")
public class SearchBookServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String type = request.getParameter("type");
        String key  = request.getParameter("key");

        try {
            String template = "select * from book where %s like '%%%s%%'";
            String sql = String.format(template, type, key);
            List<Book> books = BookRepo.getInstance().queryBook(sql);
            String table = PageTool.wrapBookTable(books);
            response.setContentType("text/html");
            try (Writer writer = response.getWriter()) {
                writer.write(PageTool.wrap(table));
            }
        } catch (SQLException | IOException e) {
            throw new ServletException(e);
        }
    }

}
