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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<fmt:setLocale value="fr" scope="session" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url var="urlResources" value="/resources" />
<!-- core styles -->

<script src="${urlResources}/plugins/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="${urlResources}/bootstrap/css/bootstrap.min.css">
<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${urlResources}/css/animate.min.css">
<sec:authentication var="principal" property="principal" />
<c:url var="urlGetPrincipalId" value="/personne/principal/id" />

</head>
<body>

	<h1 id="banner">
		<spring:message code="blog.title" text="default text" />
	</h1>

		<p align="center" ><img height="auto" src="${urlResources}/img/welcome.jpg" alt="" ></p>

<br>
	<form action="j_spring_security_check" method="POST">
		<div>
			<label><spring:message code="label.name" text="default text" /></label>
			<input type="text"
				placeholder=<spring:message code="label.name" text="default text" />
				class="form-control" name="j_username">
		</div>
		<div>
			<label><spring:message code="label.password"
					text="default text" /></label> <input type="password" id="inputPassword"
				placeholder= <spring:message code="label.password" text="default text" />
				name="j_password" class="form-control">
		</div>
		<button type="submit" class="btn btn-info">Connexion</button>
		<a href="<c:url  value="/register.do" />"
								class="btn btn-default btn-outline">Créer un compte</a>
	</form>
	
	Language :
	<a href="?lang=en">English</a>|
	<a href="?lang=fr">Francais</a>