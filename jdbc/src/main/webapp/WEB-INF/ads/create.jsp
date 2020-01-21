<%--
  Created by IntelliJ IDEA.
  User: amberjones
  Date: 1/21/20
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Create Ad</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <SCRIPT language="JavaScript">
        document.addEventListener('DOMContentLoaded', function() {
            var elems = document.querySelectorAll('select');
            var instances = M.FormSelect.init(elems, options);
        });
    </SCRIPT>
</head>
<body>
<h1>Create Ad</h1>
<div class="row">
    <form class="col s12" method="post" action="/create-ad">
        <input type="text" value="${sessionScope.user.id}" name="userId">
        <div class="row">
            <div class="input-field col s6">
                <input  id="title" type="text" class="validate" name="title" required>
                <label for="title">Title</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <input  id="description" type="text" class="validate" name="description" required>
                <label for="description">Description</label>
            </div>
        </div>
<%--        select--%>
        <div class="row">
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose your option</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Materialize Select</label>
            </div>
        </div>
<%--        end select--%>
        <div class="row">
            <input type="submit" class="btn">
        </div>
    </form>
</div>


</body>
</html>
