<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add KPac</title>
</head>
<body>
<div align="center">
    <h1>Add KPac</h1>
    <form:form action="addKPac" method="post" modelAttribute="kPac">
        <table cellpadding="5">
            <!-- below you can check real task id in db where value=id -->
            <form:hidden path="KPacId"/>
            <tr>
                <td>KPacSetId:</td>
                <td><form:input path="KPacSetId" /></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><form:input path="title" /></td>
            </tr>

            <tr>
                <td>Description:</td>
                <td><form:textarea rows="10" cols="45" path="description" /></td>
            </tr>

            <tr>
                <td>Creation Date:</td>
                <td><form:input type="date" path="createdAt" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>