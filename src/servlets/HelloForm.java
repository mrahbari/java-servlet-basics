package servlets;

/**
 * usage: http://localhost:8090/HelloForm?first_name=Reza&last_name=Ahmadi
 */

// import java libraries

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Extend HttpServlet class
public class HelloForm extends HttpServlet {

    private String docType;
    private String title;
    private String message;
    private String firstName = "MJ";    //new String("MJ");
    private String lastName = "RH";     //new String("RH");


    public void init() throws ServletException {
        // Do required initialization
        docType = "<document html>";
        title = "Welcome to my website made by servlet";
        message = "this is is the first sample of servlet by SIR MOJITO";
    }

    /*public void service(ServletRequest request,
                        ServletResponse response)
            throws ServletException, IOException {
    }*/

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        /*
        if (request.getParameter("first_name") != null)
            firstName = request.getParameter("first_name");

        if (request.getParameter("last_name") != null)
            lastName = request.getParameter("last_name");
        //OR

        // problem with assert function
        //assert (!request.getParameter("first_name").isEmpty()) : request.getParameter("first_name");
        //assert (request.getParameter("last_name") != null) : request.getParameter("last_name");
        */
        firstName = (request.getParameter("first_name") != null) ? request.getParameter("first_name") : firstName;
        lastName = (request.getParameter("last_name") != null) ? request.getParameter("last_name") : lastName;

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");

        out.println(
                "   <h1 align=\"center\">" + title + "</h1>\n" +
                        "   <h3 align=\"center\">" + message + "</h3>\n" +
                        "   <ul>\n" +
                        "       <li><b>First Name</b>: " + firstName + "\n" + "</li>" +
                        "       <li><b>Last Name</b>: " + lastName + "\n" + "</li>" +
                        "   </ul>\n"
        );

        // get all form parameters
        /*Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n<td>");

            String[] paramValues = request.getParameterValues(paramName);
            // Read single valued data
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    out.println("<i>No Value</i>");
                else
                    out.println(paramValue);
            } else {
                // Read multiple valued data
                out.println("<ul>");
                for (int i = 0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i]);
                }
                out.println("</ul>");
            }
        }*/

        /*Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String paramName = (String)headerNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n");
            String paramValue = request.getHeader(paramName);
            out.println("<td> " + paramValue + "</td></tr>\n");
        }*/

        out.println("<br>");
        String remoteHost = request.getRemoteHost();
        out.println("Remote Host:" + remoteHost + "<br>");

        out.println("<br>");
        String requestUri = request.getRequestURI();
        out.println("Request URI:" + requestUri + "<br>");

        out.println("<br>");
        String pathInfo = request.getPathInfo();
        out.println("Path Info:" + pathInfo + "<br>");

        out.println("<br>");
        String remoteAddr = request.getRemoteAddr();
        out.println("Remote Addr:" + remoteAddr + "<br>");

        out.println("<br>");
        String protocol = request.getProtocol();
        out.println("protocol:" + protocol + "<br>");

        out.println("<br>");
        String queryString = request.getQueryString();
        out.println("Query String:" + queryString + "<br>");

        out.println("<br>");
        String servletPath = request.getServletPath();
        out.println("Servlet Path:" + servletPath + "<br>");

        out.println("<br>");
        String sessionId = request.getRequestedSessionId();
        out.println("Session Id:" + sessionId + "<br>");

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
