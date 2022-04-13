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
<h2>Maj de personne</h2>
<table>
<form action=majPersonne method=post>
<tr><td>Nom :</td> 
<td><input type=text name=nom value="${personne.nom }"></td></tr>
<tr><td>Prénom :</td> 
<td><input type=text name=prenom value="${personne.prenom }"></td></tr>
<tr><td>Véhicule :</td> 
<td>
<select name="idVehicule">
<c:forEach items="${vehicules }" var="vehicule">
<option value="${vehicule.id }">${vehicule.immatriculation }</option>
</c:forEach>
</select>
</td></tr>


<tr><td><button type=submit name="id" value="${personne.id }">Ajout</button></td></tr>
</form>
</table>
</body>
</html>