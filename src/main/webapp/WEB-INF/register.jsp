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
    <h1>Register</h1>

    <form class="register-form" method="post" action="/register">

        <br>
        <label> Username:
            <input type="text" name="username" placeholder="Enter username" autocomplete="false" required>
        </label>
        <br>
        <label> Email:
            <input type="email" name="email" placeholder="example@example.com" autocomplete="false" required>
        </label>
        <br>
        <label> Password:
            <input type="password" name="password" placeholder="Enter password" autocomplete="false" required>
        </label>
        <br>
        <button class="btn btn-success" type="submit">Submit</button>
    </form>


</div>

</body>
</html>
