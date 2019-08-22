package cn.wbc.web.servlet;

import cn.wbc.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downLoadServlet")
public class downLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取请求参数，也就是获取文件名
        String filename = request.getParameter("filename");
//        使用字节输入流加载文件进内存
//        首先找到文件的真实路径，再用字节流与之关联
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
//        System.out.println(servletContext.getRealPath(filename));

        FileInputStream fis = new FileInputStream(realPath);

//           设置response的响应头

//            1.设置相应头的类型:content-type。。。。。取出文件类型
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);

        /**
         * 解决一个中文乱码的问题
         */
        //1.获取客户端的一个user-agent
        String agent = request.getHeader("user-agent");
        //2.使用工具类的一个方法编码文件名就可以
        filename = DownLoadUtils.getFileName(agent,filename);


//            2.设置响应头的打开方式：content-disposition.....以附件的形式弹窗
        response.setHeader("content-disposition","attachment;filename="+filename);

//将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff))!=1){
            sos.write(buff,0,len);
        }

        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
