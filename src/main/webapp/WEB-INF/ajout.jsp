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
<h2>Ajout de personne</h2>
<table>
<form action=ajoutPersonne method=post>
<tr><td>Nom :</td> 
<td><input type=text name=nom></td></tr>
<tr><td>Prénom :</td> 
<td><input type=text name=prenom></td></tr>
<tr><td>Véhicule :</td> 
<td>
<select name="id">
<c:forEach items="${vehicules }" var="vehicule">
<option value="${vehicule.id }">${vehicule.immatriculation }</option>
</c:forEach>
</select>
</td></tr>


<tr><td><button type=submit>Ajout</button></td></tr>
</form>
</table>
</br></br>

<h2>Ajout de véhicule</h2>
<table>
<form action=ajoutVehicule method=post>
<tr><td>Immatriculation :</td> 
<td><input type=text name=immatriculation></td></tr>
<tr><td>Type :</td> 
<td><select name="type">
<option>Voiture</option>
<option>Camion</option>
</select>
</td></tr>
<tr><td>Nombre de portes (voiture) :</td> 
<td><select name="nbPortes">
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select>
</td></tr>
<tr><td>Volume (camion) :</td> 
<td><input type=text name=volume></td></tr>
<tr><td><button type=submit>Ajout</button></td></tr>
</form>
</table>
</br></br>

<h2>Ajout de colis</h2>
<table>
<form action=ajoutColis method=post>
<tr><td>Nature :</td> 
<td><select name="nature">
<option>1</option>
<option>2</option>
<option>3</option>
</select>
</td></tr>
<tr><td>Camion :</td> 
<td>
<select name="id">
<c:forEach items="${camions }" var="camion">
<option value="${camion.id }">${camion.immatriculation }</option>
</c:forEach>
</select>
</td></tr>

<tr><td><button type=submit>Ajout</button></td></tr>
</form>
</table>
</body>
</html>