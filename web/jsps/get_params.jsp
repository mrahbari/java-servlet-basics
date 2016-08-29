<%--
  Created by IntelliJ IDEA.
  User: mrahbari
  Date: 09/06/2015
  Time: 02:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%="Welcome to partial files"%>
<%@ page import="java.util.Map" %>
<%
    Map map = request.getParameterMap();
    Object[] keys = map.keySet().toArray();
%>
<html>
<head><title>Request Parameters</title></head>
<body>
Map size = <%=map.size()%>
<table border="1">
    <tr>
        <td>Map element</td>
        <td>Par name</td>
        <td>Par value[s]</td>
    </tr>
    <%
        for (int k = 0; k < keys.length; k++) {
            String[] pars = request.getParameterValues((String) keys[k]);
            out.print("<tr>");
            out.print("<td>" + k + "</td>");        //no
            out.print("<td>" + keys[k] + "</td>");  //name
            out.print("<td>");                      //value
            for (int j = 0; j < pars.length; j++) {
                if (j > 0) out.print(", ");
                out.print("'" + pars[j] + "'");
            }
            out.println("</td>");
            out.print("</tr>");
        }
    %>

    <hr>
    <hr>
    <jsp:include page="_partial_jsp.jsp"/>

</table>
</body>
</html>
