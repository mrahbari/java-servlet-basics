<%--
S.N.	Method & Description

Cookie[] getCookies()
Returns an array containing all of the Cookie objects the client sent with this request.

Enumeration getAttributeNames()
Returns an Enumeration containing the names of the attributes available to this request.

Enumeration getHeaderNames()
Returns an enumeration of all the header names this request contains.

Enumeration getParameterNames()
Returns an Enumeration of String objects containing the names of the parameters contained in this request.

HttpSession getSession()
Returns the current session associated with this request, or if the request does not have a session, creates one.

HttpSession getSession(boolean create)
Returns the current HttpSession associated with this request or, if if there is no current session and create is true, returns a new session.

Locale getLocale()
Returns the preferred Locale that the client will accept content in, based on the Accept-Language header

Object getAttribute(String name)
Returns the value of the named attribute as an Object, or null if no attribute of the given name exists.

ServletInputStream getInputStream()
Retrieves the body of the request as binary data using a ServletInputStream.

String getAuthType()
Returns the name of the authentication scheme used to protect the servlet, for example, "BASIC" or "SSL," or null if the JSP was not protected

String getCharacterEncoding()
Returns the name of the character encoding used in the body of this request.

String getContentType()
Returns the MIME type of the body of the request, or null if the type is not known.

String getContextPath()
Returns the portion of the request URI that indicates the context of the request.

String getHeader(String name)
Returns the value of the specified request header as a String.

String getMethod()
Returns the name of the HTTP method with which this request was made, for example, GET, POST, or PUT.

String getParameter(String name)
Returns the value of a request parameter as a String, or null if the parameter does not exist.

String getPathInfo()
Returns any extra path information associated with the URL the client sent when it made this request.

String getProtocol()
Returns the name and version of the protocol the request.

String getQueryString()
Returns the query string that is contained in the request URL after the path.

String getRemoteAddr()
Returns the Internet Protocol (IP) address of the client that sent the request.

String getRemoteHost()
Returns the fully qualified name of the client that sent the request.

String getRemoteUser()
Returns the login of the user making this request, if the user has been authenticated, or null if the user has not been authenticated.

String getRequestURI()
Returns the part of this request's URL from the protocol name up to the query string in the first line of the HTTP request.

String getRequestedSessionId()
Returns the session ID specified by the client.

String getServletPath()
Returns the part of this request's URL that calls the JSP.

String[] getParameterValues(String name)
Returns an array of String objects containing all of the values the given request parameter has, or null if the parameter does not exist.

boolean isSecure()
Returns a boolean indicating whether this request was made using a secure channel, such as HTTPS.

int getContentLength()
Returns the length, in bytes, of the request body and made available by the input stream, or -1 if the length is not known.

int getIntHeader(String name)
Returns the value of the specified request header as an int.

int getServerPort()
Returns the port number on which this request was received.
--%>

<%@ page import="java.util.Enumeration" %>
<html>
<head>
    <title>HTTP Header Request Example</title>
</head>
<body>
<center>
    <h2>HTTP Header Request Example</h2>
    <table width="100%" border="1" align="center">
        <tr bgcolor="#949494">
            <th>Header Name</th>
            <th>Header Value(s)</th>
        </tr>
        <%
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String paramName = (String) headerNames.nextElement();
                out.print("<tr><td>" + paramName + "</td>\n");
                String paramValue = request.getHeader(paramName);
                out.println("<td> " + paramValue + "</td></tr>\n");
            }
        %>

        <h1>Using GET Method to Read Form Data</h1>
        <ul>
            <li><p><b>First Name:</b>
                <%= request.getParameter("first_name")%>
            </p></li>
            <li><p><b>Last  Name:</b>
                <%= request.getParameter("last_name")%>
            </p></li>
        </ul>
    </table>
</center>
</body>
</html>