<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String message =
            "This is a sample page for partials"+
            "Welcome to partial files";
%>
<h1>
    <%=message%>
</h1>


<hr>
<%--
<jsp:include page="/jsps/_getParam.jsp">
    <jsp:param name="name" value="mojtaba"></jsp:param>
    <jsp:param name="family" value="rahabri"></jsp:param>
</jsp:include>
--%>
<h1>The ways of getting parameters in jsp</h1>
Parameter name: <%= request.getParameter("name") %><br>
Parameter family: <%= request.getParameter("family") %><br><br>

name:   <c:out value="${param.name}"></c:out><br>
family: <c:out value="${param.family}"></c:out><br>

name1:  <c:out value="${param['name']}"></c:out><br>
family1:<c:out value="${param['family']}"></c:out><br>



