package com.love2code.testDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet")
public class TestDbServlet extends HttpServlet {

       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url =
                "jdbc:mysql://localhost:3306/cargo_machine_manager?useSSL=false&useJDBCCompliantTimezoneShift=true" +
                        "&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "springstudent";
        String pass = "springstudent";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database " + url);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, pass);
            out.println("Connection successful!!!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
