<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>KPAC Manager</title>
</head>
<body>
<div align="center">
    <h1>KPac List</h1>
    <h3>
        <a href="kpacs/newKPac">Add KPac</a>
    </h3>
    <table border="1" cellpadding="5">

        <tr>
            <th>id</th>
            <th>Title</th>
            <th>Description</th>
            <th>Creation Date</th>
        </tr>
        <c:forEach items="${kpacs}" var="kpac">
            <tr>
                <td>${kpac.KPacId}</td>
                <td>${kpac.title}</td>
                <td>${kpac.description}</td>
                <td>${kpac.createdAt}</td>
                <td><a href="kpacs/deleteKPac/${kpac.KPacId}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>
</div>
<div align="center"><a href="${pageContext.request.contextPath}/">Main page</a></div>
</body>
</html>