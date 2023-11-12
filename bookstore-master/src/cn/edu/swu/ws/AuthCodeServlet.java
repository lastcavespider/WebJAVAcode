package cn.edu.swu.ws;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class AuthCodeServlet extends HttpServlet {

    public final static String AUTH_CODE = "AUTH_CODE";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(120, 60, 4, 30);
        String code = captcha.getCode();
        request.getSession(true).setAttribute(AUTH_CODE, code);

        try(OutputStream outputStream = response.getOutputStream()) {
            captcha.write(outputStream);
        }
    }

}
