package cn.edu.swu;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        response.setContentType("text/html");

        if (user != null && user.equals("Tom")) {
            if (pass != null && pass.equals("123456")) {
                try(Writer writer = response.getWriter()) {
                    //response.setContentType("text/html");
                    printHeader(request,writer);
                    //response.setContentType("text/html");

                }

                return;
            }
        }

        try(Writer writer = response.getWriter()) {
            writer.write("<center><h1>Wrong user name or password, try again !!</h1></center>");
        }
    }
    private void printHeader(HttpServletRequest request,Writer writer) throws IOException {

        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements())
        {
            String name = names.nextElement();
            String value = request.getHeader(name);
            writer.write(name + ":"+value);
            writer.write("<br>");
        }
    }

}
