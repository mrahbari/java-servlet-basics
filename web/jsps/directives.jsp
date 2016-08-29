<%--

<%@ page ... %>	Defines page-dependent attributes, such as scripting language, error page, and buffering requirements.
<jsp:directive.page attribute="value" />
    --------Attribute	Purpose
    buffer	Specifies a buffering model for the output stream.
    autoFlush	Controls the behavior of the servlet output buffer.
    contentType	Defines the character encoding scheme.
    errorPage	Defines the URL of another JSP that reports on Java unchecked runtime exceptions.
    isErrorPage	Indicates if this JSP page is a URL specified by another JSP page's errorPage attribute.
    extends	Specifies a superclass that the generated servlet must extend
    import	Specifies a list of packages or classes for use in the JSP as the Java import statement does for Java classes.
    info	Defines a string that can be accessed with the servlet's getServletInfo() method.
    isThreadSafe	Defines the threading model for the generated servlet.
    language	Defines the programming language used in the JSP page.
    session	Specifies whether or not the JSP page participates in HTTP sessions
    isELIgnored	Specifies whether or not EL expression within the JSP page will be ignored.
    isScriptingEnabled	Determines if scripting elements are allowed for use.



<jsp:directive.include file="relative url" />
<%@ include file="relative url" > Includes a file during the translation phase.



<jsp:directive.taglib uri="uri" prefix="prefixOfTag" />
<%@ taglib uri="uri" prefix="prefixOfTag" >	Declares a tag library, containing custom actions, used in the page

<%@ taglib uri="http://www.example.com/custlib" prefix="mytag" %>
<html>
<body>
<mytag:hello/>
</body>
</html>
--%>
<!-- directive type is page -->
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isThreadSafe="true" %>
<%@ page buffer="8kb" %>
<%@ page autoFlush="true" %>
<%@ page pageEncoding="utf-8" %>
<%@ page session="true" %> <%-- allocate the session if it's not generated --%>
<%--<%@ page errorPage=""  %>--%>
<%--<%@ page extends="java.util.Date" %> &lt;%&ndash; extend calass to current jsp &ndash;%&gt;--%>
<%@ page info="This page is for FYI" %>

<!-- -->
<%@ page isErrorPage="false" %>
<%//= exception.getMessage()%>

<%--<%@ include file="/jsps/_getParam.jsp?name=mojtaba-include&family=rahbari-include"%>--%>
<!--Better way-->
<jsp:include page="/jsps/_getParam.jsp">
    <jsp:param name="name" value="mojtaba"></jsp:param>
    <jsp:param name="family" value="rahabri"></jsp:param>
</jsp:include>

<!-- directive type is taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
