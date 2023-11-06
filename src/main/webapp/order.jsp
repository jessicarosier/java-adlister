<%--
  Created by IntelliJ IDEA.
  User: jessicarosier
  Date: 11/3/23
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<c:choose>
    <c:when test="${order == null}">
        <form action="/pizza-order" method="POST">
            <label for="crust"> Choose your crust:
                <select name="crust" id="crust">
                    <option value="original">Original</option>
                    <option value="hand tossed">Hand Tossed</option>
                    <option value="stuffed">Original Stuffed Crust</option>
                    <option value="thin">Thin 'N Crispy</option>
                </select>
            </label>

            <br>

            <label for="sauce"> Choose your sauce:
                <select name="sauce" id="sauce">
                    <option value="marinara">Marinara</option>
                    <option value="hand tossed"></option>
                    <option value="thin">Thin</option>
                </select>
            </label>

            <br>

            <label for="size"> Choose your size:
                <select name="size" id="size">
                    <option value="small">Small</option>
                    <option value="medium">Medium</option>
                    <option value="large">Large</option>
                    <option value="xlarge">X-Large</option>
                </select>
            </label>

            <br>

            <label for="pepperoni"> Pepperoni
                <input type="checkbox" id="pepperoni" name="pepperoni" value="pepperoni">
            </label>
            <label for="sausage"> Sausage
                <input type="checkbox" id="sausage" name="sausage" value="sausage">
            </label>
            <label for="mushrooms"> Mushrooms
                <input type="checkbox" id="mushrooms" name="mushrooms" value="mushrooms">
            </label>
            <label for="pineapple"> Pineapple
                <input type="checkbox" id="pineapple" name="pineapple" value="pineapple">
            </label>

            <br>
            <br>
            <label for="address"> Delivery Address:
                <input type="text" name="address" id="address">
            </label>

            <button type="submit">Submit Order</button>
        </form>
    </c:when>

    <c:otherwise>
        <div class="d-flex flex-column justify-content-center">
            <div class="d-flex justify-content-center align-items-center">
                <h1>Thank you for your order! Your order details are below!</h1>
                <p>Crust: ${crust}</p>
                <p>Sauce: ${sauce}</p>
                <p>Size: ${size}</p>
                <p>Toppings:
                    <c:forEach var="topping" items="${toppings}">
                    ${topping},
                </c:forEach>
                </p>
                <p> Delivery Address: ${address}</p>
            </div>
        </div>
    </c:otherwise>
</c:choose>


</body>
</html>
