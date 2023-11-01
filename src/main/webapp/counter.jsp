<%--
  Created by IntelliJ IDEA.
  User: jessicarosier
  Date: 11/1/23
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--  <%! this tag is used to INITIALIZE/DECLARE a variable %>   --%>
<%! int counter = 0; %>
<%--   <% this tag is used to redecalre the caribale    --%>
<% counter ++; %>
<html>
<head>
  <title>Title</title>
  <%@ include file="partials/head.jsp" %>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<%--   <%= this tag is used to USE the variable and diaplay its value dynamically %>  --%>
<h1>The current count is <%= counter %>.</h1>

View the page source!

<%-- this is a JSP comment, you will *not* see this in the html --%>

<!-- this is an HTML comment, you *will* see this in the html -->

</body>
</html>


