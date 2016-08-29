package servlets;

/**
 * Created by mrahbari on 07/07/2015.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ConfigDemoServlet implements Servlet {

    private Enumeration parameters;

    public void init(ServletConfig config) throws ServletException {
        parameters = config.getInitParameterNames();
        while (parameters.hasMoreElements()) {
            String parameter = (String) parameters.nextElement();
            System.out.println("Parameter name : " + parameter);
            System.out.println("Parameter value : " + config.getInitParameter(parameter));
        }

        System.out.println("DB driver is : " + config.getInitParameter("dbDriver"));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response, ServletConfig config)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = "Detecting Locale";
        String docType = "<!doctype html\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        while (parameters.hasMoreElements()) {
            String parameter = (String) parameters.nextElement();
            out.println("<h1>Parameter name : " + parameter + "</h1>");
            out.println("<h1>Parameter value : " + config.getInitParameter(parameter) + "</h1>");
        }
        out.println("<h1> DB driver is : " + config.getInitParameter("dbDriver") + "</h1>");
        out.println(
                "</body></html>");
    }

    public void destroy() {
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    }

    public String getServletInfo() {
        return null;
    }

    public ServletConfig getServletConfig() {
        return null;
    }
}