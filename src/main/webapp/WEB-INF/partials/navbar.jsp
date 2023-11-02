<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <c:choose>
        <c:when test="<%=session.getAttribute("user") == null%>">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout">logout
            </a></li>
            </c:when>
            <c:otherwise>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login">login
                </a></li>
            </c:otherwise>
            </c:choose>

        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
