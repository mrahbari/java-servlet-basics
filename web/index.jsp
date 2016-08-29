<%--
  Created by IntelliJ IDEA.
  User: mrahbari
  Date: 06/17/2015
  Time: 08:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Mojtaba Rahbari">
    <title>First Template for Servlet</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/signin.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <form class="form-signin" action="HelloForm" method="POST">

        <h2 class="form-signin-heading">Please fill your data</h2>

        <label for="first_name" class="sr-only">First Name</label>
        <input type="text" id="first_name" name="first_name" class="form-control" placeholder="First Name" required
               autofocus>

        <label for="last_name" class="sr-only">Last Name</label>
        <input type="text" id="last_name" name="last_name" class="form-control" placeholder="Last Name">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form>


    <hr>
    <div class="text-justify">
        <a href="jsps/index-jstl.jsp" class="text-warning">JSTL Page</a><small class="text-info">&nbsp;(<a href="/jstl" class="text-info">JSTL Via WEB.XML</a>)</small>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="jsps/index-jsp.jsp" class="text-warning">JSP Page</a><small class="text-info">&nbsp;(<a href="/jsp2" class="text-info">JSP Via WEB.XML</a>)</small>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="jsps/private_tags/index.jsp" class="text-warning">Create Private Tags</a>
    </div>
    <hr>
    <div class="text-justify">
        <a href="ServletExample" class="text-warning">Servlet</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="CookieExample" class="text-danger">Cookie</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="SessionTrack" class="text-primary">Session</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="DatabaseAccess" class="text-primary">JDBC</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="ContextLog" class="text-primary">ContextLog</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="GetLocale" class="text-primary">GetLocale</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="CurrentDate" class="text-primary">CurrentDate</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="PageRedirect" class="text-primary">PageRedirect</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="DisplayAttributesServlet" class="text-primary">DisplayAttributesServlet</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="PageRequest" class="text-primary">PageRequest</a>
        &nbsp;&nbsp;|&nbsp;&nbsp;
    </div>
    <hr>
    <div>
        <%--

        <%
            String  browserDetails  =   request.getHeader("User-Agent");
            String  userAgent       =   browserDetails;
            String  user            =   userAgent.toLowerCase();

            String os = "";
            String browser = "";
            float version = (float) 10.0;


            //out.println("User Agent for the request is===>"+browserDetails);
            //out.println("<br>");
            //=================OS=======================
            if (userAgent.toLowerCase().indexOf("windows") >= 0 )
            {
                os = "Windows";
            } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
            {
                os = "Mac";
            } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
            {
                os = "Unix";
            } else if(userAgent.toLowerCase().indexOf("android") >= 0)
            {
                os = "Android";
            } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
            {
                os = "IPhone";
            }else{
                os = "UnKnown, More-Info: "+userAgent;
            }
            //===============Browser===========================
            if (user.contains("msie"))
            {
                String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
                browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
            } else if (user.contains("safari") && user.contains("version"))
            {
                browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            } else if ( user.contains("opr") || user.contains("opera"))
            {
                if(user.contains("opera"))
                    browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
                else if(user.contains("opr"))
                    browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
            } else if (user.contains("chrome"))
            {
                browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
            } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
            {
                //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
                browser = "Netscape-?";

            } else if (user.contains("firefox"))
            {
                browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
            } else if(user.contains("rv"))
            {
                try{
                    int pos = user.indexOf("rv") + 3;
                    version = Float.parseFloat(user.substring(pos,pos+2));
                }catch(Exception e){
                    // nothing to do
                    System.out.println(e);
                }
                browser="IE";
            } else
            {
                browser = "UnKnown, More-Info: "+userAgent;
            }



           // out.println("Operating System======>"+os);
            //out.println("Browser Name==========>" + browser);
            if (browser.equals("IE") && version < 9.0) {
                out.println("Your IE version is:" + version + " ,Please update your Browser at the moment!");
            } else if (browser.equals("IE")){
                out.println("Your IE version is:" + version + ",Fine!");
            }
        %>
        --%>
        <%
            String  browserDetails  =   request.getHeader("User-Agent");
            String  userAgent       =   browserDetails;
            String  user            =   userAgent.toLowerCase();

            String browser = "";
            float version = (float) 10.0;

            if (user.contains("msie"))
            {
                String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
                browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
            } else if(user.contains("rv"))
            {
                try{
                    int pos = user.indexOf("rv") + 3;
                    version = Float.parseFloat(user.substring(pos,pos+2));
                    //version = (float) 8.76; //just for test
                }catch(Exception e){}
                browser="IE";
            }

            // out.println("Operating System======>"+os);
            //out.println("Browser Name==========>" + browser);
            if (browser.equals("IE") && version < 9.0) {
                out.println("Your IE version is:" + version + " ,Please update your Browser ASAP!");
            } else if (browser.equals("IE")){
                out.println("Your IE version is:" + version + ",Fine!");
            }
        %>
    </div>
    <hr>
</div>
</body>
</html>
