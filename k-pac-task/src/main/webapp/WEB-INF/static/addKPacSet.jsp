<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add KPacSet</title>
</head>
<body>
<div align="center">
    <h1>Add KPacSet</h1>
    <form:form action="addKPacSet" method="post" modelAttribute="kPacSet">
        <table cellpadding="5">
            <!-- below you can check real task id in db where value=id -->
            <form:hidden path="KPacSetId"/>
            <tr>
                <td>KPacId:</td>
                <td><form:input path="KPacId" /></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><form:input path="title" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>