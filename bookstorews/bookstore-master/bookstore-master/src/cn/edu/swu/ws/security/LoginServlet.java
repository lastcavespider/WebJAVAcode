package cn.edu.swu.ws.security;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String code = request.getParameter("code");
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);

        if (code == null || !code.equalsIgnoreCase((String) session.getAttribute(AuthCodeServlet.AUTH_CODE))) {
            response.sendRedirect("./admin.html");
            return;
        }

        if (user != null && user.equals("admin")) {
            if (pass != null && pass.equals("123456")) {
                session.setAttribute(AuthFilter.AUTH_STATUS, AuthStatus.LOGIN_SUCCESS);
                // 返回一个重定向
                response.sendRedirect("./main");
                return;
            }
        }

        // 返回 HTTP 错误提示
        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "用户名密码不正确，请重新登陆！");
        try(Writer writer = response.getWriter()) {
            response.setHeader("Refresh", "5;url=./admin.html");
            writer.write("<center><h1 style='color:red'>用户名密码不正确，需要重新登陆，5秒后自动跳转！</h1></center>");
        }
    }

    private String printHeaders(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table style='width:70%' cellpadding='5px' cellspacing='20px'>");
        sb.append("<tr style='background-color:#336699;color:#FFF'><th>Header名称</th><th>Header值</th></tr>");

        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            sb.append(String.format("<tr style='background-color:#eee'><td>%s</td><td>%s</td></tr>",
                    name, request.getHeader(name)));
        }
        sb.append("</table>");

        return sb.toString();
    }

    private String printParameters(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table style='width:70%' cellpadding='5px' cellspacing='20px'>");
        sb.append("<tr style='background-color:#336699;color:#FFF'><th>参数名称</th><th>参数值</th></tr>");

        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            sb.append(String.format("<tr style='background-color:#eee'><td>%s</td><td>%s</td></tr>",
                    name, request.getParameter(name)));
        }
        sb.append("</table>");

        return sb.toString();
    }

}
