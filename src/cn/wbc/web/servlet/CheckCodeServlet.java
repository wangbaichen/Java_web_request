package cn.wbc.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1在内存中创建一个图片对象，（验证码图片）
         */
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //2.美化图片
            //2.1定义画笔工具
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);//设置画笔颜色
            //2.2画背景
        g.fillRect(0,0,width-1,height-1);//设置画的范围
            //2.2用画笔画边框
        g.setColor(Color.BLACK);
        g.drawRect(0,0,width-1,height-1);
            //2.3写验证码
                //将str给随机起来
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
            //生成随机角标
        Random random = new Random();

        for (int i = 1; i <5; i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//产生随机字符
            g.drawString(ch+"",width/5*i,height/2);
        }


        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
