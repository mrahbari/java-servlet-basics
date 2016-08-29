<%--
  Created by IntelliJ IDEA.
  User: mrahbari
  Date: 09/12/2015
  Time: 01:45 PM
  To change this template use File | Settings | File Templates.


  http://localhost:8099/jsps/chapter4/actions.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<% String filename = "hello.jsp"; //jsps/chapter4/%>
<jsp:forward page="<%=filename%>">
  <jsp:param name="name" value="mojtaba"/>
  <jsp:param name="family" value="rahbari"/>
</jsp:forward>
This is 100 percent equivalent to the following scriptlet:

<% String vars = "?name=mojtaba2&family=rahbari2";
  String dest = "jsps/chapter4/hello.jsp" + vars; //jsps/chapter4/
  RequestDispatcher rd = application.getRequestDispatcher(dest);
  rd.forward(request, response);
%>

</body>
</html>
