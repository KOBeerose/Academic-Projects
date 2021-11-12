package com.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "TableShow", value = "/TableShow")
public class TableShow extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String db = request.getParameter("db");

        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
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
        out.println("</body></html>");


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
