package cn.wbc.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 完成一个重定向的操作
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 重定向的实现过程有两个步骤
         * 1.高速浏览器状态吗是302；
         * 2.高速浏览器重定向到的一个资源路径是哪里
         */

        System.out.println("demo1....... ");
        //1.设置状态码
        response.setStatus(302);
        //2.设置Demo2的资源路径
        response.setHeader("location","/ResponseDemo2");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
