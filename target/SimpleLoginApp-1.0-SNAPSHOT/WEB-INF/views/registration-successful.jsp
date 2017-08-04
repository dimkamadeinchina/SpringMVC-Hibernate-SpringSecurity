<%--
  Created by IntelliJ IDEA.
  User: ДИМА
  Date: 01.08.2017
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>INDEX PAGE</title>
    <link href="<c:url value="css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="css/jumbotron-narrow.css" />" rel="stylesheet">
</head>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation"><a href="/login">Login</a></li>
                <li role="presentation"><a href="/registration">Registration</a></li>
                <li role="presentation"><a href="/about">Information</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">Main page</h3>
    </div>


    <div class="row marketing">
        <div class="col-lg-12">
            <h4></h4>
            <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

            <h4>Subheading</h4>
            <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

            <h4>Subheading</h4>
            <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>
    </div>

    <footer class="footer">
        <p>© 2017 Company, Inc.</p>
    </footer>

</div>
<!--
        <form:form action="logout">
            <div>
                <button type="submit">Logout</button>
            </div>
        </form:form>
    </div>
</div>
-->
</body>
</html>
