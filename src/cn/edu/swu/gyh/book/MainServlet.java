package cn.edu.swu.gyh.book;

import cn.edu.swu.gyh.common.Conf;
import cn.edu.swu.gyh.common.PageTool;
import cn.edu.swu.gyh.common.Pager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

// 注释 annotation
@WebServlet("/main")
public class MainServlet extends HttpServlet {

    public final static int PageSize = 4;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String page = request.getParameter("page");
            int currentPage = page != null ? Integer.valueOf(page) : 1;
            String pagesize = request.getParameter("pageSize");
            int pageSize = pagesize != null ? Integer.valueOf(pagesize) : Conf.PAGE_SIZE;

            int offset = (currentPage - 1) * pageSize;

            String sql = String.format("select * from book order by id desc limit %s offset %s ", pageSize, offset);
            List<Book> books = BookRepo.getInstance().queryBook(sql);
            String table = PageTool.wrapBookTable(books);

            Pager pager = new Pager();
            pager.setUrl("./main?");
            pager.setCurrentPage(currentPage);
            pager.setTotal(BookRepo.getInstance().totalBooks());
            pager.setPageSize(pageSize);

            response.setContentType("text/html");
            try (Writer writer = response.getWriter()) {
                writer.write(PageTool.wrap(table + pager.toHtml()));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
