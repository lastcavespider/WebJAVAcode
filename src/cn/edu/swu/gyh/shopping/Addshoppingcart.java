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




@WebServlet("/Addshopping.html")
public class Addshoppingcart extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String id = request.getParameter("bookId");
        try {
            Book book = BookRepo.getInstance().getBookById(id);
            String template = """
                 <form action="./addCart" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="%s"/>
                        书名：<input type="text" name="name" value="%s"><br><br>
                        作者：<input type="text" name="author" value="%s"><br><br>
                        价格：<input type="text" name="price" value="%s"><br><br>
                        内容：<textarea cols='20' rows='3' name="content">%s</textarea><br><br>
                        图片：<input type="file" name="picture"/> <br><br>
                        <input type="submit" value="加入购物车">
                </form>
            """;
            String form = String.format(template, book.getId(),
                    book.getName(), book.getAuthor(), book.getPrice(), book.getContent());
            String html = PageTool.wrap(form);

            response.setContentType("text/html");
            try(Writer writer = response.getWriter()) {
                writer.write(html);
            }

        } catch (SQLException | IOException e) {
            throw new ServletException(e);
        }

    }

}