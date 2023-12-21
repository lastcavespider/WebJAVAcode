package cn.edu.swu.gyh.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter extends HttpFilter {

    public final static String AUTH_STATUS = "AUTH_STATUS";
    public final static String INIT_PARAM_IGNORE_URLS = "ignoreUrls";

    private String[] ignoreUrls = null;

    public void init(FilterConfig filterConfig){
        String urls = filterConfig.getInitParameter(INIT_PARAM_IGNORE_URLS);
        if (urls != null) {
            this.ignoreUrls = urls.split(";");
        }
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 放行不需要拦截的资源路径
        String uri = request.getRequestURI();
//        if (uri.endsWith("admin.html") || uri.endsWith("/login")
//            || uri.endsWith("png") || uri.endsWith("jpg")
//            || uri.endsWith(".css") || uri.endsWith(".js")) {
//            chain.doFilter(request, response);
//            return;
//        }
        for (String ignoreUrl : this.ignoreUrls) {
            if (uri.endsWith(ignoreUrl)) {
                chain.doFilter(request, response);
                return;
            }
        }

        // 对其它资源进行登录验证
        HttpSession session = request.getSession(true);
        AuthStatus authStatus = (AuthStatus) session.getAttribute(AUTH_STATUS);
        if ( authStatus != null && authStatus.equals(AuthStatus.LOGIN_SUCCESS) ) {
            chain.doFilter(request, response);
            return;
        } else {
            response.sendRedirect("./index.html");
        }
    }

}
