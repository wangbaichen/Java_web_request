package cn.wbc.web.servlet;

import cn.wbc.dao.UserDao;
import cn.wbc.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@javax.servlet.annotation.WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
//        //2.获取请求参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        //3.封装user对象
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);

        //2.获取所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //3.创建User对象
        User loginUser = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //4.调用UserDao的login方法
        UserDao userDao = new UserDao();
        User login = userDao.login(loginUser);
        //5.判断
        if(login==null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            request.setAttribute("login",login);
            request.getRequestDispatcher("/scuessServlet").forward(request,response);
        }

    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
