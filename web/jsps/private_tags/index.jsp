<%--
  Created by IntelliJ IDEA.
  User: mrahbari
  Date: 10/07/2015
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="test" uri="/WEB-INF/private-tags/TagsDescriptor.tld" %>
<html>
<head>
    <title>JSP Custom Taglib example: Substr function</title>
</head>
<body>
SUBSTR(GOODMORNING, 1, 6) is
<span color="blue">
    <test:substring input="GOODMORNING" start="1" end="6"/>
</span>
<hr>

<!--
    To Check it use below url addess
    http://localhost:8099/jsps/private_tags/index.jsp?status=ok
-->
<test:status>
   Current time is:<%= new java.util.Date()%>
   <br>
    Content of tags is printed...
</test:status>
</body>
</html>
