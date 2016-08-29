<%@page language="java" contentType="text/html"%>
<%@page import="java.util.*"%>
<html><head><title>Request Headers</title></head><body>
<%

  /*Vector hedVec = (Vector) request.getHeaderNames();
    for (Object hev : hedVec){
        out.print(hev);
    }*/

    // Getting Iterator from arrayLinkedList to traverse elements
    /*Vector hedVec = (Vector) request.getHeaderNames();
    Iterator itr = hedVec.iterator();
    while (itr.hasNext()) {
        System.out.println(itr.next());
    }
    System.out.println("\n");*/

  Enumeration headers = request.getHeaderNames();
  int kh = 0;
  while (headers.hasMoreElements()) {
    String hName = (String)headers.nextElement();
    out.println("------- " + hName);
    Enumeration hValues = request.getHeaders(hName);
    while (hValues.hasMoreElements()) {
      out.println("<br/>&nbsp;&nbsp;&nbsp;" + hValues.nextElement());
      }
    out.println("<br/>");
    }
  %>
</body></html>
