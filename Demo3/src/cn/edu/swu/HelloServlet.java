package cn.edu.swu;



import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class HelloServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet Initializing");
    }

    public void destroy() {
        System.out.println("Servlet Destroy");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Servlet doGet Service");
        response.setContentType("text/html");
        try(Writer writer = response.getWriter()) {
            writer.write("<center><h1>Hello World from Servelt In Smart Tomcat !</h1></center>");
        }
    }


}
