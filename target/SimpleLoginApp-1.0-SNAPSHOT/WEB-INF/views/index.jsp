<%--
  Created by IntelliJ IDEA.
  User: ДИМА
  Date: 01.08.2017
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <h1>Home Page</h1>
        <h2>${message}</h2>

        <a href="/admin" />Admin Page</a>
        <br>
        <a href="/user" />User Page</a>
        <br><br>
        <form:form action="logout">
            <div>
                <button type="submit">Logout</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
