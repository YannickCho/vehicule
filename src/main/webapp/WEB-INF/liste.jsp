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
<h2>Liste des voitures</h2>
<table border=2>
<tr><td>Immatriculation</td><td>Nb de portes</td></tr>
<tr>
<c:forEach items="${voitures }" var="voiture" varStatus="status">
<td><c:out value="${voiture.immatriculation }"/></td>
<td><c:out value="${voiture.nbPortes }"/></td>
<td><a href="suppVehicule?&id=${voiture.id }"><button>Supprimer</button></a></td>
<td><a href="majVoiture?&id=${voiture.id }"><button>Mettre à jour</button></a></td>
</tr>
</c:forEach>

</table>

<h2>Liste des camions</h2>
<table border=2>
<tr><td>Immatriculation</td><td>Volume</td></tr>
<tr>
<c:forEach items="${camions }" var="camion" varStatus="status">
<td><c:out value="${camion.immatriculation }"/></td>
<td><c:out value="${camion.volume }"/></td>
<td><a href="suppVehicule?&id=${camion.id }"><button>Supprimer</button></a></td>
<td><a href="majCamion?&id=${camion.id }"><button>Mettre à jour</button></a></td>
</tr>
</c:forEach>

</table>

<h2>Liste des personnes</h2>
<table border=2>
<tr><td>Nom</td><td>Prénom</td><td>Véhicule</td></tr>
<tr>
<c:forEach items="${personnes }" var="personne" varStatus="status">
<td><c:out value="${personne.nom }"/></td>
<td><c:out value="${personne.prenom }"/></td>
<td><c:out value="${personne.vehicule.immatriculation }"/></td>
<td><a href="suppPersonne?&id=${personne.id }"><button>Supprimer</button></a></td>
<td><a href="majPersonne?&id=${personne.id }"><button>Mettre à jour</button></a></td>
</tr>
</c:forEach>

</table>

<h2>Liste des colis</h2>
<table border=2>
<tr><td>Nature</td><td>Camion</td></tr>
<tr>
<c:forEach items="${colis }" var="coli" varStatus="status">
<td><c:out value="${coli.nature }"/></td>
<td><c:out value="${coli.camion.immatriculation }"/></td>
<td><a href="suppColis?&id=${coli.id }"><button>Supprimer</button></a></td>
<td><a href="majColis?&id=${coli.id }"><button>Mettre à jour</button></a></td>
</tr>
</c:forEach>

</table>
</br></br>
<a href="index.jsp">Retour à l'accueil</a>
</body>
</html>