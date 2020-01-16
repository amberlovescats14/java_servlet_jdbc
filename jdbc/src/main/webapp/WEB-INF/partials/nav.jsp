<%--
  Created by IntelliJ IDEA.
  User: amberjones
  Date: 1/16/20
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>nav</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo left">Welcome</a>
        <ul id="nav-mobile" class="right ">
        <c:if test="${!sessionScope.loggedIn}">
            <li><a href="/login" class="waves-effect waves-light btn">Login</a></li>
            <li><a href="/register" class="waves-effect waves-light btn">Register</a></li>

        </c:if>
            <c:if test="${sessionScope.loggedIn}">
                <li>
                <form action="/logout" method="post">
                    <button type="submit" class="waves-effect waves-light btn">Logout</button>
                </form>
                </li>
                <li><a href="/edit-profile"
                class="waves-effect waves-light btn">Edit Profile</a></li>
            </c:if>
            <li><a href="all-users"
            class="waves-effect waves-light btn">All Users</a></li>
<%--            <li><a href="collapsible.html">JavaScript</a></li>--%>
        </ul>
    </div>
</nav>

</body>
</html>
