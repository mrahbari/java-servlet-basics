package servlets;

// Loading required libraries

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;

public class DatabaseAccess extends HttpServlet {

    // ORACLE
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@172.16.78.200:1631:pnatest";

    //  Database credentials
    private static final String DB_USER = "test_2";
    private static final String DB_PASS = "test_2";

    Connection dbConnection = null;
    Statement stmt = null;


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

        String title = "Database Result";
        String docType = "<!doctype html\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");

        if (dbConnection!=null)
            out.println("Connection is successfully!");

        try {
            // Execute SQL query
            stmt = dbConnection.createStatement();


            // add data in database
            /*String sql2 = "INSERT INTO tbl_customers (id, first_name, last_name, course) VALUES (4, '1Mojtaba', 'Rahbari', 'C1')";
            String sql3 = "INSERT INTO tbl_customers (id, first_name, last_name, course) VALUES (5, '2Reza', 'Omrani', 'C2')";
            String sql4 = "INSERT INTO tbl_customers (id, first_name, last_name, course) VALUES (6, '3Kazem', 'Alikhani', 'C3')";
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);*/

            // get cutstomers list
            String sql = "select * from tbl_customers";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String course = rs.getString("course");

                //Display values
                out.println("ID: " + id + "<br>");
                out.println("First Name: " + firstName + "<br>");
                out.println("Last Name: " + lastName + "<br>");
                out.println("Course: " + course + "<br><hr>");
            }

            rs.close();
            stmt.close();

            if (dbConnection!=null)
                dbConnection.close();

        } catch (SQLException e) {
            out.println("SQLException <br>");
            e.printStackTrace();
            out.println(e.getMessage());
        } catch (Exception e) {
            out.println("Other Exception <br>");
            out.println(e.getMessage());
        }
        out.println("</body></html>");
    }
}