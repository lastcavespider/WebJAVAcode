package cn.edu.swu.gyh.shopping;

import cn.edu.swu.gyh.book.Book;
import cn.edu.swu.gyh.book.BookRepo;
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

@WebServlet("/CartSearch")
public class SearchBookCart extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String type = request.getParameter("type");
        String key  = request.getParameter("key");

        try {
            String template = "select * from shoppingcart where %s like '%%%s%%'";
            String sql = String.format(template, type, key);
            List<Book> books = CartRepo.getInstance().queryBook(sql);
            String table = ShoppingPageTool.wrapBookTable(books);
            response.setContentType("text/html");
            try (Writer writer = response.getWriter()) {
                writer.write(ShoppingPageTool.wrap(table));
            }
        } catch (SQLException | IOException e) {
            throw new ServletException(e);
        }
    }

}
