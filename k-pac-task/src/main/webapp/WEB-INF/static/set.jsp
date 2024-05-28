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
    <tr>
        <th>KPacId</th>
        <th>KPacSetId</th>
    </tr>
    <c:forEach var="kPacKpacSetDto" items="${kPacKPacSetDto}">
        <table border="1" cellpadding="5">
            <tr>
                <td>${kPacKpacSetDto.KPacSetId}</td>
                <td>${kPacKpacSetDto.KPacSet.title}</td>
                <td>${kPacKpacSetDto.KPacId}</td>
                <td>${kPacKpacSetDto.KPac.title}</td>
                <td>${kPacKpacSetDto.KPac.description}</td>
                <td>${kPacKpacSetDto.KPac.createdAt}</td>
            </tr>
        </table>
    </c:forEach>
</div>
<div align="center"><a href="${pageContext.request.contextPath}/sets">Main page</a></div>
</body>
</html>