package cn.edu.swu.gyh.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/books")
public class QueryBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException {

        try {
            String sql = "select * from book order by id desc";
            List<Book> books = BookRepo.getInstance().queryBook(sql);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(books);



            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try(Writer writer = response.getWriter()){
                writer.write(json);
            }

        } catch (SQLException | IOException e) {
            throw new ServletException(e);
        }
    }


}
