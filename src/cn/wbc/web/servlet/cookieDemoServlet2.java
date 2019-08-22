package cn.wbc.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemoServlet2")
public class cookieDemoServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         *
         * 获取cookie拿到数据
         */
        Cookie[] cookies = request.getCookies();
        //看到数组类型的第一反应就是要把它遍历出来
        if(cookies!=null){
            for (Cookie c : cookies){
                String name = c.getName();
                String value = c.getValue();//由此可以看出他使用map这种结构存储的数据
                System.out.println(name+"  "+value);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
