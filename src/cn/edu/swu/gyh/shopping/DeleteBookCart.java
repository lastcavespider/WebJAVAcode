package cn.edu.swu.gyh.shopping;

import cn.edu.swu.gyh.book.BookRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteBookCart")
public class DeleteBookCart extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Integer id = Integer.valueOf(request.getParameter("bookId"));
        try {
            CartRepo.getInstance().deleteBookById(id);
            response.sendRedirect("./ShoppingCart");
        } catch (SQLException | IOException e) {
            throw new ServletException(e);
        }
    }

}
