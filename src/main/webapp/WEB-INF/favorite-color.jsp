<%--
  Created by IntelliJ IDEA.
  User: jessicarosier
  Date: 11/2/23
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favorite Color</title>
</head>
<body>
<form action="favorite-color" method="post" >
  <label for="color">
    Choose your favorite color:
  <select name="color" id="color">
    <option value="blue">Blue</option>
    <option value="red">Red</option>
    <option value="green">Green</option>
    <option value="purple">Purple</option>
  </select>
  </label>
  <button type="submit">Submit</button>
</form>

</body>
</html>
