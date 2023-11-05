package cn.edu.swu;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter extends HttpFilter {
    public static String LOGIN_STATUS = "LOGIN_STATUS";
    public void doFilter (HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    {
        request.getContextPath();
        HttpSession session = request.getSession(true);
        LoginStatus status = (LoginStatus) session.getAttribute(LOGIN_STATUS);
        if(status == null)
        {

        }
    }

}
