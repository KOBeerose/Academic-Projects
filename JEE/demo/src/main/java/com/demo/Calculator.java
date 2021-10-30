package com.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator", value = "/add")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nb1=Integer.parseInt(request.getParameter("nb1"));
        int nb2=Integer.parseInt(request.getParameter("nb2"));
        int sum=nb1+nb2;
        PrintWriter out = response.getWriter();
        out.println("the sum of "+nb1 +" and "+ nb2+" is "+sum);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
