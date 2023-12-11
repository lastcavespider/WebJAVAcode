package cn.edu.swu.ws.book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {





        Integer id = Integer.valueOf(request.getParameter("bookId"));
        try {
            BookRepo.getInstance().deleteBookById(id);
            response.sendRedirect("./main");
        } catch (SQLException | IOException e) {
            throw new ServletException(e);
        }
    }

}
