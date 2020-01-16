<%--
  Created by IntelliJ IDEA.
  User: amberjones
  Date: 1/16/20
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
<c:import url="../partials/nav.jsp"/>
<%--proofile--%>
<h1>Welcome ${sessionScope.user.getUsername()}</h1>
<form action="/delete" method="post">
    <input type="submit" value="Delete Profile">
</form>

</body>
</html>
