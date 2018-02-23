<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marjan
  Date: 2/19/18
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">

    <title>Hello, world!</title>
</head>
<body>
<div class="container-fluid">
    <br>
    <form action="<c:url value="/person.do"/>" method="post">
        <input type="hidden" name="${action}">
        <input type="hidden" name="id" value="${person.id}">
        <div class="form-group">
            <input type="text" placeholder="Name" name="name" value="${person.name}">
            <input type="submit" value="Save" class="btn btn-primary btn-sm">
        </div>
    </form>
    <br>

    <table class="table table-sm table-bordered table-hover table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.get('personList')}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>
                    <form action="<c:url value="/person.do"/>" method="get">
                        <input type="hidden" name="edit">
                        <input type="hidden" name="id" value="${p.id}">
                        <input type="submit" value="edit" class="btn btn-danger btn-sm" aria-hidden="true">
                    </form>
                </td>
                <td>
                    <form action="<c:url value="/person.do"/>" method="post">
                        <input type="hidden" name="delete">
                        <input type="hidden" name="id" value="${p.id}">
                        <input type="submit" value="delete" aria-hidden="true">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="<c:url value="/resources/jquery/jquery-3.2.1.slim.min.js"/>"></script>
<script src="<c:url value="/resources/popper.min.js"/>"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
