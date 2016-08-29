package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MultipleValuesRequest extends HttpServlet {

    private void sendLoginForm(HttpServletResponse response, boolean withErrorMessage)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Login</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");

        if (withErrorMessage)
           out.println("Login failed. Please try again.<BR>");

        out.println("<BR>");
        out.println("<BR>Please enter your user name and password.");
        out.println("<BR><FORM METHOD=POST>");
        out.println("<BR>User Name: <INPUT TYPE=TEXT NAME=userName>");
        out.println("<BR>Password: <INPUT TYPE=PASSWORD NAME=password>");
        out.println("<BR><INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");


        out.println("<BR>");
        out.println("<BR>Select your favorite music:");
        out.println("<BR><FORM METHOD=POST>");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=favoriteMusic VALUE=Rock>Rock");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=favoriteMusic VALUE=Jazz>Jazz");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=favoriteMusic VALUE=Classical>Classical");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=favoriteMusic VALUE=Country>Country");
        out.println("<BR><INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");

        out.println("</BODY>");
        out.println("</HTML>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        sendLoginForm(response, false);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get and print multi values params
        String[] values = request.getParameterValues("favoriteMusic");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (values != null) {
            out.println("You have selected: ");
            for (String value : values) {
                out.println("<BR>" + value);
            }
            /*
            int length = values.length;
            for (int i=0; i<length; i++) {
                out.println("<BR>" + values[i]);
            }*/
        }

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (userName != null && password != null && userName.equals("jamesb") && password.equals("007")) {
            response.sendRedirect("http://domain/app/WelcomePage");
        } else {
            sendLoginForm(response, true);
        }
    }
}