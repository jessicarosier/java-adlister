<%--
  Created by IntelliJ IDEA.
  User: jessicarosier
  Date: 11/6/23
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ads.dao.Ads</title>
</head>
<body>


    <c:forEach items="${ads}" var="ad">
       <h1>${ad.title}</h1>
        <p>${ad.description}</p>
    </c:forEach>




</body>
</html>
