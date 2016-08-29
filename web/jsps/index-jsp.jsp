<%--
  Created by IntelliJ IDEA.
  User: mrahbari
  Date: 09/06/2015
  Time: 02:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %>


<%--
<% SuperClass spBean = new SubClass(); %>
<jsp:useBean id="spBean" class="SubClass" type="SuperClass"></jsp:useBean>
--%>

<%--<% servlets.UserBean userBean = new servlets.UserBean(); %>--%>
<jsp:useBean id="userBean" class="servlets.UserBean" scope="application"></jsp:useBean>


<html>
<head><title>Request Parameters</title></head>
<body>


<h1><%=userBean.getFamily()%></h1>
<jsp:getProperty name="userBean" property="family"></jsp:getProperty>


<h1><%=userBean.getName()%></h1>
<jsp:getProperty name="userBean" property="name"></jsp:getProperty>

<hr>

<h1><% userBean.setName("FT"); %></h1>
<jsp:setProperty name="userBean" property="name" value="FT2"></jsp:setProperty>

<h1><% userBean.setFamily("NIKI"); %></h1>
<jsp:setProperty name="userBean" property="family" value="NIKI2"></jsp:setProperty>


<hr>
<!-- set all variables values from request -->
<jsp:setProperty name="userBean" property="*"></jsp:setProperty>
<hr>



<%= new Date()%>

<hr>
<% // condition sample %>
<% Integer i = 12;%>
<%=(i>2) ? "yes" : "no"%>
<hr>


<% // include sample %>
<jsp:include page="/jsps/_partial.jsp"></jsp:include>

<% //declare variables %>
<% int k1 = 0;           //a new variable is created for each incoming HTTP client request (the same as define variable in jspInit() || jsp file)%>
<%! int k2 = 0;          //a new variable is created for each new instance of the servlet (the same as define variable in SERVLET CLASS)%>
<%! static int k3 = 0;   //the variable is shared among all instances of the servlet (the same as define variable in SERVLET CLASS WITH STATIC TYPE)%>

<%-- Duto read web.xml parameters, following code was added--%>
<!-- init parameters -->

<%=name%>
<%!
  String name;
  public void jspInit(){
    ServletConfig config = getServletConfig();
    name = config.getInitParameter("name");
  }

%>

</body>
</html>
