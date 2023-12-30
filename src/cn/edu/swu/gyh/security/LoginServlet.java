package cn.edu.swu.gyh.security;

import cn.edu.swu.gyh.common.dao.LoginDao;
import jakarta.servlet.ServletException;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }



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
        boolean star = LoginDao.loginStar(user, pass); //将获取的账号密码传过去，如果账号密码正确就会返回true
        if ( star ) {
            //登陆成功，在session中添加登陆成功的标记
            session.setAttribute(AuthFilter.AUTH_STATUS, AuthStatus.LOGIN_SUCCESS);
            //返回一个重定向
            response.sendRedirect("./main");

            System.out.println(user+pass);

            return;
        }

        //错误提示
        try (Writer writer = response.getWriter()) {
            response.setHeader("Refresh", "5;url=./index.html"); //隔5秒钟刷新到index.html这个网页
            writer.write("<center><h1 style='color:red'>用户名密码不正确，需要重新登录，5秒后自动跳转！</h1></center>");
        }





        //固定用户的验证方式
//        if (user != null && user.equals("admin")) {
//            if (pass != null && pass.equals("123456")) {
//                session.setAttribute(AuthFilter.AUTH_STATUS, AuthStatus.LOGIN_SUCCESS);
//                // 返回一个重定向
//                response.sendRedirect("./main");
//                return;
//            }
//        }

        // 返回 HTTP 错误提示
        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "用户名密码不正确，请重新登陆！");
//        try(Writer writer = response.getWriter()) {
//            response.setHeader("Refresh", "5;url=./admin.html");
//            writer.write("<center><h1 style='color:red'>用户名密码不正确，需要重新登陆，5秒后自动跳转！</h1></center>");
//        }
    }

//    private String printHeaders(HttpServletRequest request) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("<table style='width:70%' cellpadding='5px' cellspacing='20px'>");
//        sb.append("<tr style='background-color:#336699;color:#FFF'><th>Header名称</th><th>Header值</th></tr>");
//
//        Enumeration<String> names = request.getHeaderNames();
//        while(names.hasMoreElements()) {
//            String name = names.nextElement();
//            sb.append(String.format("<tr style='background-color:#eee'><td>%s</td><td>%s</td></tr>",
//                    name, request.getHeader(name)));
//        }
//        sb.append("</table>");
//
//        return sb.toString();
//    }
//
//    private String printParameters(HttpServletRequest request) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("<table style='width:70%' cellpadding='5px' cellspacing='20px'>");
//        sb.append("<tr style='background-color:#336699;color:#FFF'><th>参数名称</th><th>参数值</th></tr>");
//
//        Enumeration<String> names = request.getParameterNames();
//        while(names.hasMoreElements()) {
//            String name = names.nextElement();
//            sb.append(String.format("<tr style='background-color:#eee'><td>%s</td><td>%s</td></tr>",
//                    name, request.getParameter(name)));
//        }
//        sb.append("</table>");
//
//        return sb.toString();
//    }

}
