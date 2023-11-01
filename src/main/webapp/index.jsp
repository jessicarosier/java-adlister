<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String title = "A cool title"; %>
<%! int num = 20; %>
<html>
<head>
    <title><%= title %></title>
    <%@ include file="partials/head.jsp" %>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>


<h1>Implicit Object in action:</h1>
<p>Path: <%= request.getRequestURL() %></p>
<%--http://localhost:8080/?name=Jessica--%>
<p>Query String: <%= request.getQueryString() %></p>
<p>"name" parameter: <%= request.getParameter("name") %></p>
<p>"method" attribute: <%= request.getMethod() %></p>
<%--dont understand WHEN i need to use ${} vs <%= %>  %>}--%>
<%--<p>User-Agent header: ${request.getHeader("user-agent") }</p>--%>


<%-- This assumes we are visiting a page and have ?page_no=5 (or something
     similar) appended to the query string --%>
<p>"page_no" parameter: ${param.page_no}</p>

<p>User-Agent header: ${header["user-agent"]}</p>
<p>User-Agent header: ${header["user-agent"]}</p>
<p><%= 2+ 2 %></p>
<% request.setAttribute("message", "Hello World!"); %>

<h1>${message}</h1>

      <p><%=num > 9%></p>
    <c:if test='<%= num > 9 %>'>
        <h1>Variable names should be very descriptive</h1>
    </c:if>
    <c:if test="true">
        <h1>single letter variable names are good</h1>
    </c:if>
</body>
</html>
