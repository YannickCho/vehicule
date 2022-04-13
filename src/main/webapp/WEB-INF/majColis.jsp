<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Maj de colis</h2>
<table>
<form action=majColis method=post>
<tr><td>Nature :</td> 
<td><select name="nature">
<option>1</option>
<option>2</option>
<option>3</option>
</select>
</td></tr>
<tr><td>Camion :</td> 
<td>
<select name="idCamion">
<c:forEach items="${camions }" var="camion">
<option value="${camion.id }">${camion.immatriculation }</option>
</c:forEach>
</select>
</td></tr>

<tr><td><button type=submit name="id" value="${colis.id }">Mise à jour</button></td></tr>
</form>
</table>
</body>
</html>