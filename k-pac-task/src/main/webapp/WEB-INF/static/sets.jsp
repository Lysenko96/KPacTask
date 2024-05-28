<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>KPacSet Manager</title>
</head>
<body>
<div align="center">

    <h1>KPacKPacSet List</h1>
    <h3>
        <a href="sets/newKPacSet">Add KPacSet</a>
    </h3>
    <tr>
        <th>KPacSetId</th>
        <th>title</th>
    </tr>
    <c:forEach var="kPacSet" items="${kPacSets}">
        <table border="1" cellpadding="5">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/set/${kPacSet.KPacSetId}"> ${kPacSet.KPacSetId}</a>
                </td>
                <td>${kPacSet.title}</td>
                <td><a href="sets/deleteKPacSet/${kPacSet.KPacSetId}">Delete</a></td>
            </tr>
        </table>

    </c:forEach>
    <tr>
        <th>FreeKPac</th>
    </tr>
    <c:forEach var="FreeKPac" items="${FreeKPacs}">
        <table border="1" cellpadding="5">
            <tr>
                <td>${FreeKPac.KPacId}</td>
            </tr>
        </table>
    </c:forEach>

</div>
<div align="center"><a href="${pageContext.request.contextPath}/">Main page</a></div>
</body>
</html>