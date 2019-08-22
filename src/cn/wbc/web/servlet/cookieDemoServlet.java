package cn.wbc.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemoServlet")
public class cookieDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 创建cookie对象
         *
         * 发送cookie
         *
         * 获取cookie拿到数据
         */
        Cookie cookie = new Cookie("msg", "hello");
        response.addCookie(cookie);
        response.sendRedirect("/cookieDemoServlet2");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
