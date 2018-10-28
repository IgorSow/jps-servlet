package com.sda;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String nameToDisplay = StringUtils.isEmpty(name) ? "annonimus" : name;
        PrintWriter writer = response.getWriter();
        writer.print("<h1>Hello World" + nameToDisplay + "</h1>");

    }


}
