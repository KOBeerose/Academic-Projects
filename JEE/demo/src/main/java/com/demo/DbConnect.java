package com.demo;

import java.sql.*;

public class DbConnect {
    public static Connection connect(String db){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+db,"root","");
        }
        catch(Exception e){ System.out.println(e);}
        return con;
    }
}
