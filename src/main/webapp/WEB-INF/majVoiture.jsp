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
<h2>Maj de voiture</h2>
<table>
<form action=majVoiture method=post>
<tr><td>Immatriculation :</td> 
<td><input type=text name=immatriculation value="${voiture.immatriculation }"></td></tr>
<tr><td>Nombre de portes :</td> 
<td><select name="nbPortes">
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select>
</td></tr>

<tr><td><button type=submit name="id" value="${voiture.id }">Mise à jour</button></td></tr>
</form>
</table>
</body>
</html>