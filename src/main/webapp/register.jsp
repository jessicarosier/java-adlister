<%--
  Created by IntelliJ IDEA.
  User: jessicarosier
  Date: 11/7/23
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register for an account"/>
    </jsp:include>
</head>
<body>
<div class="page-wrapper">

<div class="register-form">

    <form method="post" action="/register" class="w-50">
        <label> Name:
            <input type="text" name="name" placeholder="John Doe" autocomplete="false">
        </label>
        <br>
        <label> Email:
            <input type="email" name="email" placeholder="example@example.com" autocomplete="false">
        </label>
        <br>
        <label> Password:
            <input type="password" name="password" placeholder="password" autocomplete="false">
        </label>

    </form>
</div>

</div>

</body>
</html>
