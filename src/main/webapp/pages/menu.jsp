<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@
taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<jsp:include page="/template/header.jsp">
	<jsp:param value="active" name="menuAdministrateurActive" />
	<jsp:param value="Solices - Détails Administrateur" name="titreOnglet" />
</jsp:include>

<body>
<center> <h2>Menu</h2> </center>
<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="app bg-default horizontal-layout">
			
			
			<tr>
			<p>Pour accéder à la liste des personnes, cliquer <a href="/springTPJSP/personne/list.do" >ici</a></p>
			<p>Pour accéder à la liste des catégories, cliquer <a href="/springTPJSP/categorie/list.do" >ici</a></p>
			<p>Pour accéder à ma page test, cliquer <a href="/springTPJSP/pages/test.jsp" >ici</a></p>
			</tr>
</body>