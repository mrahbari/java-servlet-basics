package servlets;

/**
 * usage: http://localhost:8090/HelloForm?first_name=Reza&last_name=Ahmadi
 */

// import java libraries

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Extend HttpServlet class
public class CookieExample extends HttpServlet {

    private String docType;
    private String title;
    private String message;
    private String firstName = "Mojtaba";    //new String("MJ");
    private String lastName = "Rahbari";     //new String("RH");


    public void init() throws ServletException {
        // Do required initialization
        docType = "<document html>";
        title = "Welcome to my website made by servlet";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Create cookies for first and last names.
        Cookie fnCookie = new Cookie("firstName", firstName);
        Cookie lnCookie = new Cookie("lastName", lastName);

        // Set expiry date after 24 Hrs for both the cookies.
        fnCookie.setMaxAge(60 * 60 * 24);
        lnCookie.setMaxAge(60 * 60 * 24);

        // Add both the cookies in the response header.
        response.addCookie(fnCookie);
        response.addCookie(lnCookie);

        //////////////////////////////////////////////////////////////////////
        // get cookies
        Cookie cookie = null;
        Cookie cookies[] = null;
        cookies = request.getCookies();

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");


        out.println("fnCookie Name:" + fnCookie.getName() + "<br>");
        out.println("fnCookie Value:" + fnCookie.getValue() + "<br>");


        out.println("lnCookie Name:" + lnCookie.getName() + "<br>");
        out.println("lnCookie Value:" + lnCookie.getValue() + "<br>");

        if (cookies != null) {
            out.println("<h2> Found Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];

                // show cookies
                out.print("Name : " + cookie.getName() + ",  ");
                out.print("Value: " + cookie.getValue() + " <br/>");

                // remove firstName cookie
                /*if((cookie.getName( )).compareTo("firstName") == 0 ){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.print("Deleted cookie : " + cookie.getName( ) + "<br/>");
                }*/
            }
        } else {
            out.println(
                    "<h2>No cookies founds</h2>");
        }

        out.println(
                "</body>" +
                        "</html>"
        );
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
        // do nothing.
    }
}
