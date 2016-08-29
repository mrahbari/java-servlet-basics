<%--
S.N.	Method & Description

String encodeRedirectURL(String url)
Encodes the specified URL for use in the sendRedirect method or, if encoding is not needed, returns the URL unchanged.

String encodeURL(String url)
Encodes the specified URL by including the session ID in it, or, if encoding is not needed, returns the URL unchanged.

boolean containsHeader(String name)
Returns a boolean indicating whether the named response header has already been set.

boolean isCommitted()
Returns a boolean indicating if the response has been committed.

void addCookie(Cookie cookie)
Adds the specified cookie to the response.

void addDateHeader(String name, long date)
Adds a response header with the given name and date-value.

void addHeader(String name, String value)
Adds a response header with the given name and value.

void addIntHeader(String name, int value)
Adds a response header with the given name and integer value.

void flushBuffer()
Forces any content in the buffer to be written to the client.

void reset()
Clears any data that exists in the buffer as well as the status code and headers.

void resetBuffer()
Clears the content of the underlying buffer in the response without clearing headers or status code.

void sendError(int sc)
Sends an error response to the client using the specified status code and clearing the buffer.

void sendError(int sc, String msg)
Sends an error response to the client using the specified status.

void sendRedirect(String location)
Sends a temporary redirect response to the client using the specified redirect location URL.

void setBufferSize(int size)
Sets the preferred buffer size for the body of the response.

void setCharacterEncoding(String charset)
Sets the character encoding (MIME charset) of the response being sent to the client, for example, to UTF-8.

void setContentLength(int len)
Sets the length of the content body in the response In HTTP servlets, this method sets the HTTP Content-Length header.

void setContentType(String type)
Sets the content type of the response being sent to the client, if the response has not been committed yet.

void setDateHeader(String name, long date)
Sets a response header with the given name and date-value.

void setHeader(String name, String value)
Sets a response header with the given name and value.

void setIntHeader(String name, int value)
Sets a response header with the given name and integer value.

void setLocale(Locale loc)
Sets the locale of the response, if the response has not been committed yet.

void setStatus(int sc)
Sets the status code for this response.
--%>

<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
    <title>Auto Refresh Header Example</title>
</head>
<body>
<center>
    <h2>Auto Refresh Header Example</h2>
    <%
        // Set refresh, autoload time as 5 seconds
        response.setIntHeader("Refresh", 5);
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
        out.println("Current Time is: " + CT + "\n");
    %>
</center>
</body>
</html>