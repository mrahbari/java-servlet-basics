  <%@page language="java" contentType="text/html"%>
<%@page errorPage="stack_trace.jsp"%>
<html><head><title>Cause null pointer exception</title></head><body>
<%

  String clientLocale = request.getLocale().toString();
  out.print(clientLocale);
  out.print("<hr>");

  String a = request.getParameter("notThere");
  int len = a.length(); // causes a null pointer exception
  %>
</body></html>
