<%--
  Created by IntelliJ IDEA.
  User: amberjones
  Date: 1/18/20
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>All Ads</title>
    <c:import url="/WEB-INF/partials/head.jsp"/>
</head>
<body>
<h1>All Ads</h1>

<c:forEach var="item" items="${allAds}">
    <div class="card">
        <div class="card-content">
            <div class="card-title">
                    ${item.title}
            </div>
            Description: ${item.description}
            <div class="card-action">
                <c:if test="${not empty sessionScope.loggedIn}">
                    <c:if test="${sessionScope.loggedIn}">
                        <c:if test="${item.userId eq sessionScope.user.id}">
                            <a class="waves-effect waves-light btn-small"
                               href="/edit-ad">Edit Ad</a>
                        </c:if>
                    </c:if>
                </c:if>
            </div>
        </div>
    </div>
</c:forEach>


</body>
</html>
