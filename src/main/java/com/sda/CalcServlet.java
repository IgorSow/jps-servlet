package com.sda;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String a = request.getParameter("a");
        String b = request.getParameter("b");

        Integer integer = Optional.ofNullable(request.getParameter("a"))
                .filter(e -> StringUtils.isNumeric(e))
                .map(e -> Integer.valueOf(a))
                .orElse(0);

        Integer firstNum = StringUtils.isNumeric(a) ?  Integer.valueOf(a)  : 0;
        Integer secondNum = StringUtils.isNumeric(b) ?  Integer.valueOf(b)  : 0;
        int result = firstNum + secondNum;

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1> Sum two numbers is :" + result + "</h1>");
    }
}
