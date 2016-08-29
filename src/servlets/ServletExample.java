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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// Extend HttpServlet class
public class ServletExample extends HttpServlet {

    private String docType;
    private String title;
    private String httpRequestStatus;

    public void init() throws ServletException {
        // Do required initialization
        docType = "<document html>";
        title = "Http Status Codes";
        httpRequestStatus = "<table class=\"table table-bordered\">\n" +
                "  <tbody><tr>\n" +
                "    <th align=\"left\" style=\"width:10%\">Code:</th>\n" +
                "    <th align=\"left\" style=\"width:30%\">Message:</th>\n" +
                "    <th align=\"left\" style=\"width:60%\">Description:</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">100</td><td> Continue</td>\n" +
                "    <td valign=\"top\"> Only a part of the request has been received by the server, but as long as it has not  been rejected, the client should continue with the request</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">101</td><td> Switching Protocols</td>\n" +
                "    <td valign=\"top\">The server switches protocol.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">200</td><td class='text-danger'> OK</td>\n" +
                "    <td valign=\"top\">The request is OK</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">201</td><td> Created</td>\n" +
                "    <td valign=\"top\">The request is complete, and a new resource is  created&nbsp;</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">202</td><td> Accepted</td>\n" +
                "    <td valign=\"top\">The request is accepted for processing, but the processing is not complete.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">203</td><td style=\"width:36%;\"> Non-authoritative Information</td>\n" +
                "    <td valign=\"top\">&nbsp;</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">204 </td><td>No Content</td>\n" +
                "    <td valign=\"top\">&nbsp; </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">205</td><td> Reset Content</td>\n" +
                "    <td valign=\"top\">&nbsp;</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">206</td><td> Partial Content</td>\n" +
                "    <td valign=\"top\">&nbsp; </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">300</td><td> Multiple Choices</td>\n" +
                "    <td valign=\"top\">A link list. The user can select a link and go to that location. Maximum five addresses &nbsp;</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">301</td><td> Moved Permanently</td>\n" +
                "    <td valign=\"top\">The requested page has moved to a new url&nbsp;</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">302</td><td> Found</td>\n" +
                "    <td valign=\"top\">The requested page has moved temporarily to a new url&nbsp;\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">303</td><td> See Other</td>\n" +
                "    <td valign=\"top\">The requested page can be found under a different url&nbsp;\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">304</td><td> Not Modified</td>\n" +
                "    <td valign=\"top\">&nbsp;</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">305</td><td> Use Proxy</td>\n" +
                "    <td valign=\"top\">&nbsp;\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">306</td><td> <i>Unused</i></td>\n" +
                " \n" +
                "    <td valign=\"top\">This code was used in a previous version. It is no longer used, but the code is reserved.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">307</td><td> Temporary Redirect</td>\n" +
                "    <td valign=\"top\">The requested page has moved temporarily to a new url.</td>\n" +
                "  </tr>\n" +
                "   <tr>\n" +
                "    <td valign=\"top\">400</td><td class='text-danger'>Bad Request</td>\n" +
                "    <td valign=\"top\">The server did not understand the request</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">401</td><td class='text-danger'> Unauthorized</td>\n" +
                "    <td valign=\"top\">The requested page needs a username and a password</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">402</td><td> Payment Required</td>\n" +
                "    <td valign=\"top\"><i>You can not use this code yet</i> </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">403</td><td class='text-danger'> Forbidden</td>\n" +
                "    <td valign=\"top\">Access is forbidden to the requested page </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">404</td><td class='text-danger'> Not Found</td>\n" +
                "    <td valign=\"top\">The server can not find the requested page.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">405</td><td> Method Not Allowed</td> \n" +
                "    <td valign=\"top\">The method specified in the request is not allowed.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">406</td><td> Not Acceptable</td>\n" +
                "    <td valign=\"top\">The server can only generate a response that is not accepted by the client.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">407 </td><td>Proxy Authentication Required</td>\n" +
                "    <td valign=\"top\">You must authenticate with a proxy server before this  request can be served.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">408</td><td> Request Timeout</td>\n" +
                "    <td valign=\"top\">The request took longer than the server was prepared to wait.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">409</td><td> Conflict</td>\n" +
                "    <td valign=\"top\">The request could not be completed because of a conflict.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">410 </td><td>Gone</td>\n" +
                "    <td valign=\"top\">The requested page is no longer available.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">411</td><td> Length Required</td>\n" +
                "    <td valign=\"top\">The \"Content-Length\" is not defined. The server will not accept the request without it.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">412</td><td> Precondition Failed</td>\n" +
                "    <td valign=\"top\">The precondition given in the request evaluated to false by the server.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">413</td><td> Request Entity Too Large</td>\n" +
                "    <td valign=\"top\">The server will not accept the request, because the request entity is too large.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">414</td><td> Request-url Too Long</td>\n" +
                "    <td valign=\"top\">The server will not accept the request, because the url is too long. Occurs when you convert a \"post\" request to a \"get\" request with  a long query information.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">415</td><td> Unsupported Media Type</td>\n" +
                "    <td valign=\"top\">The server will not accept the request, because the media  type is not supported.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">417</td><td> Expectation Failed</td>\n" +
                "    <td valign=\"top\">&nbsp;</td> \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">500</td><td class='text-danger'>Internal Server Error</td>\n" +
                "    <td valign=\"top\">The request was not completed. The server met an unexpected condition</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">501</td><td> Not Implemented</td>\n" +
                "    <td valign=\"top\">The request was not completed. The server did not support  the functionality required.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">502</td><td> Bad Gateway</td>\n" +
                "    <td valign=\"top\">The request was not completed. The server received an invalid response from the upstream server </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">503</td><td> Service Unavailable</td>\n" +
                "    <td valign=\"top\">The request was not completed. The server is temporarily overloading or down.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">504</td><td> Gateway Timeout</td>\n" +
                "    <td valign=\"top\">The gateway has timed out.</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td valign=\"top\">505</td><td> HTTP Version Not Supported</td>\n" +
                "    <td valign=\"top\">The server does not support the \"http protocol\" version. </td>\n" +
                "  </tr>\n" +
                "</tbody></table>";

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

        // Set refresh, autoload time as 5 seconds
        response.setIntHeader("Refresh", 5);

        //response.setStatus(400);

        // Set error code and reason.
        //response.sendError(407, "Need authentication!!!" );

        // note: HTTP Status 500 - Cannot call sendRedirect() after the response has been committed
        //response.sendRedirect("HelloForm");

        // Get current time
        Calendar calendar = new GregorianCalendar();
        String am_pm;

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if(calendar.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";

        String CT = hour+":"+ minute +":"+ second +" "+ am_pm;


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        //get current date time with Date()
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        //get current date time with Calendar()
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='utf-8'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1'>\n" +
                        "    <meta name='author' content='Mojtaba Rahbari'>\n" +
                        "    <title>Servlet Example for Servlet</title>\n" +
                        "\n" +
                        "    <!-- Bootstrap core CSS -->\n" +
                        "    <link href='./assets/css/bootstrap.min.css' rel='stylesheet'>\n" +
                        "    <link href='./assets/css/signin.css' rel='stylesheet'>\n" +
                        "\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div class='container'>\n"
        );

        out.println("<h1>" + title + "</h1>\n");
        out.println("<p>Current Time is: " + CT + "</p>\n");
        out.println("<p>Current Time zone is: " + calendar.getTime() + "</p>\n");
        out.println(httpRequestStatus);

        /*out.println("<br>");
        String remoteHost = request.getRemoteHost();
        out.println("Remote Host:" + remoteHost + "<br>");

        out.println("<br>");
        String requestUri = request.getRequestURI();
        out.println("Request URI:" + requestUri + "<br>");*/

        out.println(
                        "</div>\n" +
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
