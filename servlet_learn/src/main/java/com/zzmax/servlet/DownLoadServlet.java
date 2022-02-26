package com.zzmax.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/download")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取请求参数 （文件名称）
        String fileName = request.getParameter("fileName");
        // 2. 字节输入流 加载文件到内存

        // 2.1 找到文件的服务器路径
        jakarta.servlet.ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + fileName);
        // 2.2 用字节流读入
        InputStream fileInputStream = new FileInputStream(realPath);

        // 3. 设置响应头的打开方式
        response.setHeader("content-disposition","attachment;filename=" + fileName);

        // 4. 将输入流中的数据写到输出流（借助缓冲）
        ServletOutputStream sos = response.getOutputStream();

        //缓冲区
        byte[] buff = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buff)) != -1){
            sos.write(buff,0,len);
        }

        fileInputStream.close();
        sos.close();
    }
}
