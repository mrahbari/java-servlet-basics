<%--
  Created by IntelliJ IDEA.
  User: mrahbari
  Date: 06/17/2015
  Time: 08:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Mojtaba Rahbari">
    <title>JSTL Section</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/signin.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="text-justify">
        <h2>forEach</h2>
        <blockquote>
            <%
                String words[] = {"ali", "reza", "maryam", "fatemeh", "foo", "bar", "baz"};
                request.setAttribute("words", words);
            %>
            <H2>Key Words:</H2>
            <ul>
                <c:forEach var="word" items="${words}">
                    <li>${word}</li>
                </c:forEach>
            </ul>
            <h2>Values of the test Parameter:</h2>
            <ul>
                <c:forEach var="val" items="${paramValues.test}">
                    <li>${val}</li>
                </c:forEach>
            </ul>

            <hr>
            <%--
            Status subproperties
                – index (int: the current index)
                – first (boolean: is this the first entry?)
                – last (boolean: is this the first entry?)
                – begin (Integer: value of 'begin' attribute)
                – end (Integer: value of end' attribute)
                – step (Integer: value of 'step' attribute)
            --%>
            <% String[] names = {"Joe", "Jane", "Juan", "Juana"};
                request.setAttribute("names", names); %>
            <h2>Names:
                <c:forEach var="name" items="${names}" varStatus="status">
                    ${name}
                    <c:if test="${!status.last}">,</c:if>
                </c:forEach>
            </h2>

            <hr>
            <ul>
                <c:forEach var="i" begin="1" end="10">
                    <li>${i}</li>
                    <c:if test="${i > 7}">
                        (greater than 7)
                    </c:if>
                </c:forEach>
            </ul>

        </blockquote>
        <blockquote>
            <h2>Switch(choose) & foreach</h2>
            <ul>
                <c:forEach var="i" begin="1" end="10">
                <li>${i}
                    <c:choose>
                        <c:when test="${i < 4}">
                            (small)
                        </c:when>
                        <c:when test="${i < 8}">
                            (medium)
                        </c:when>
                        <c:otherwise>
                            (large)
                        </c:otherwise>
                    </c:choose>
                    </c:forEach>
                </li>
            </ul>
        </blockquote>

        <%--
        <c:redirect url="../index.jsp"></c:redirect>
        --%>

        <blockquote>
            <h2>Out</h2>
            <c:out value="${1+2}" default="0"></c:out>
        </blockquote>


        <h2>forEach</h2>
        <blockquote>
                <%
                int dollars = 12343234;
                request.setAttribute("dollars", dollars);
            %>
            <fmt:formatNumber value="${dollars}" type="currency"/>
        </blockquote>
    </div>
</div>
</body>
</html>
