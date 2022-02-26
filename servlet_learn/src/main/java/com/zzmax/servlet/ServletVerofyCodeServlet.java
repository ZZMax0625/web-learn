package com.zzmax.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/code")
public class ServletVerofyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义验证码的大小
        int width = 240;
        int height = 90;

        // 创建一个在内存中存放验证码图片的对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 绘制图片
        // 画笔对象
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);

        // 绘制边框
        graphics.setColor(Color.gray);
        graphics.drawRect(0,0,width - 1,height - 1);
        String str = "ADSFSJDHRJ02325EHRJKEHFJKHJKHJKF1240232545";

        //随机生成下标
        Random random = new Random();

        // 四位验证码
        for (int i = 1;i < 5;i++){
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            graphics.drawString(String.valueOf(ch),width / 5 * i,height / 3);
        }

        // 绘制干扰线
        graphics.setColor(Color.green);
        int rgbRed = 0;
        int rgbGreen = 0;
        int rgbBlue = 0;

        for (int i = 0;i < 10;i++){

            graphics.setColor(new Color(rgbRed,rgbGreen,rgbBlue));

            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);

            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);

            graphics.drawLine(x1,y1,x2,y2);

            rgbRed = random.nextInt(256);
            rgbGreen = random.nextInt(256);
            rgbBlue = random.nextInt(256);
        }

        // 验证码输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());

    }
}
