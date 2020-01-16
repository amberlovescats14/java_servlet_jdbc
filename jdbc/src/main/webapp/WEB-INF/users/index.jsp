<%--
  Created by IntelliJ IDEA.
  User: amberjones
  Date: 1/15/20
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>All Users</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>
<c:import url="../partials/nav.jsp"/>
<h1>All users</h1>
<c:forEach var="item" items="${allUsers}">
    <div class="card">
        <div class="card-content">
            <div class="card-title">
        ${item.username}
            </div>
        Email: ${item.email}
        Password: ${item.password}
            <div class="card-action">
        <c:if test="${not empty sessionScope.loggedIn}">
            <c:if test="${sessionScope.loggedIn}">
                <c:if test="${item.id eq sessionScope.user.id}">
                    <a class="waves-effect waves-light btn-small"
                    href="/profile">View Profile</a>
                </c:if>
            </c:if>
        </c:if>
            </div>
        </div>
    </div>
</c:forEach>


</body>
</html>
