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


//        Integer integer = Optional.ofNullable(request.getParameter("a"))
//                .filter(e -> StringUtils.isNumeric(e))
//                .map(e -> Integer.valueOf(a))
//                .orElse(0);

        Integer firstNum = StringUtils.isNumeric(a) ? Integer.valueOf(a) : 0;
        Integer secondNum = StringUtils.isNumeric(b) ? Integer.valueOf(b) : 0;

        System.out.println(">>>>>>>>>>>>>>>" + request.getRemoteAddr());

        CalculationResult result = calculate(request.getPathInfo(), firstNum, secondNum);

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>" + result.resultRepresentation +  "</h1>");


    }

    private CalculationResult calculate(String path, int a, int b) {
        if (path.endsWith("add")) {
            return new CalculationResult(a + b,
                    a + " + " + b + " = " + (a + b));
        } else if (path.endsWith("subtraction")) {
            return new CalculationResult(a - b,
                    a + " - " + b + " = " + (a - b));
        } else if (path.endsWith("multiply")) {
            return new CalculationResult(a * b,
                    a + " * " + b + " = " + (a * b));
        } else
            return new CalculationResult(0,
                    "Unsupported operation");
    }


    private static class CalculationResult {
        private Integer result;
        private String resultRepresentation;

        public CalculationResult(Integer result, String resultRepresentation) {
            this.result = result;
            this.resultRepresentation = resultRepresentation;
        }

        public Integer getResult() {
            return result;
        }

        public String getResultRepresentation() {
            return resultRepresentation;
        }
    }
}
