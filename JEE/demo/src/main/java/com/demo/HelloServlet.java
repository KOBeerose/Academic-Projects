package com.demo;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String db = "test";

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        try {
            Connection con = DbConnect.connect(db);
            //Creating a Statement object
            Statement stmt = con.createStatement();
            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");
            out.println("Tables in the current database: ");
            while (rs.next()) {
                out.print(rs.getString(1));
                out.println();
            }
        }
        catch(Exception e){ out.println(e);}



    }

    public void destroy() {
    }
}