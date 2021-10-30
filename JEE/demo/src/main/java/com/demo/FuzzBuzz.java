package com.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FizzBuzz", value = "/FizzBuzz")
public class FuzzBuzz extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int min=Integer.parseInt(request.getParameter("min"));
        int max=Integer.parseInt(request.getParameter("max"));
        PrintWriter out = response.getWriter();
        for (int i=min; i<=max; i++){
            String test = "";
            test = (i%3==0 & i%7==0) ? "FizzBuzz\n":
                    (i%3==0) ? "Fizz\n":
                            (i%7==0) ? "Buzz\n": Integer.toString(i);
            out.println(test);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
