<%--
  Created by IntelliJ IDEA.
  User: jessicarosier
  Date: 10/30/23
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%--specifies the content type of the page, in this case html using java--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <%@ include file="partials/head.jsp" %>
</head>

<body>
<%@ include file="partials/navbar.jsp" %>

<%--    Inside of login.jsp write some code to check the submmitted values. If the username submitted is "admin", and the password is "password", redirect the user to the profile page; otherwise, redirect back to the login form.--%>

<%--<%--%>
<%--    String username = request.getParameter("name");--%>
<%--    String password = request.getParameter("password");--%>

<%--    try {--%>
<%--        if(username.equals("admin") && password.equals("password")) {--%>
<%--            response.sendRedirect("profile.jsp");--%>
<%--        }--%>
<%--    } catch (Exception e) {--%>
<%--        e.printStackTrace();--%>
<%--    }--%>
<%--%>--%>


<form method="POST" action="login.jsp">
    <label for="username">
        Username:
        <input type="text" name="username" id="username">
    </label>
    <br>
    <label for="password">
        Password:
        <input type="password" name="password" id="password">
    </label>
    <br>
    <button type="submit">Submit</button>
    <br>
</form>

<%--<h1><%= username %>--%>
<%--</h1>--%>
<%--<h1><%= password %>--%>
<%--</h1>--%>

<c:choose>
    <c:when test="${param.username.equals('admin') && param.password.equals('password')}">
        <c:redirect url="profile.jsp"/>
    </c:when>
</c:choose>

</body>
</html>
