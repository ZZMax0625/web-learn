package com.zzmax.cookie_session_learn;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

@WebServlet(name = "ServletB", value = "/ServletB")
@Slf4j
public class ServletB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            String name = cookie.getName();
            if ("username".equals(name)){
                String value = cookie.getValue();
                // logback还没弄好，课后再弄
                System.out.println("name00:" + value);
                log.info("name01:");
                log.error("name02:" + value);

                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
