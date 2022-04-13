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
<h2>Maj de camion</h2>
<table>
<form action=majCamion method=post>
<tr><td>Immatriculation :</td> 
<td><input type=text name=immatriculation value="${camion.immatriculation }"></td></tr>
<tr><td>Volume (camion) :</td> 
<td><input type=text name=volume value="${camion.volume }"></td></tr>
<tr><td><button type=submit name="id" value="${camion.id }">Mise à jour</button></td></tr>
</form>
</table>
</body>
</html>