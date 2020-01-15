<%--
  Created by IntelliJ IDEA.
  User: amberjones
  Date: 1/15/20
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

<div class="row">
    <form class="col s12" method="post" action="/register">
        <div class="row">
            <div class="input-field col s6">
                <input  id="username" type="text" class="validate" name="username" required>
                <label for="username">Username</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <input  id="email" type="text" class="validate" name="email" required>
                <label for="email">Email</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <input  id="password" type="text" class="validate" name="password" required>
                <label for="password">Password</label>
            </div>
        </div>
        <div class="row">
            <input type="submit" class="btn">
        </div>
    </form>
</div>

</body>
</html>
