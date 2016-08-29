<%--
  Created by IntelliJ IDEA.
  User: mrahbari
  Date: 09/12/2015
  Time: 03:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="UserBean" class="servlets.UserBean"></jsp:useBean>
<html>
<head>
    <title></title>
</head>
<body>
<%
  String name = request.getParameter("name");
  String family = request.getParameter("family");
%>
name:   <%=name%><br>
family: <%=family%><br>
<hr>

<H1>WITH PURE JSP</H1>

<jsp:useBean id="name3" scope="request"/>
<jsp:useBean id="family3" scope="request"/>
<%--name3:   <%=name3%><br>
family3: <%=family3%><br>--%>
<%=UserBean.getName()%>
<%=UserBean.getFamily()%>
<H1>WITH JSTL</H1>
<%
    request.setAttribute("name", name);
    request.setAttribute("family", family);
%>
name:   <c:out value="${name}"></c:out><br>
family: <c:out value="${family}"></c:out><br>
