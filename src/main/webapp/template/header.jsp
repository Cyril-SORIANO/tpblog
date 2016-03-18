<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
    <style type="text/css">
      body { 
        background-color:#DDD;
        padding-top: 10px;
      }
      [class*="col-"] { margin-bottom: 20px; }
      img { width: 100%; }
      .well {
        background-color:#CCC;
        padding: 20px;
      }
      a:active, a:focus { outline:none; }
      .inline-form input {
        display: inline-block;
        width: 100px;
      }
    </style>
<sec:authentication var="principal" property="principal" />
<c:url var="urlGetPrincipalId" value="/personne/principal/id" />
<title>My first blog</title>
</head>


<body class="bg-default">
    <div class="container">
      <nav class="navbar navbar-inverse" role="navigation">   
        <div class="navbar-header">   
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">My Blog</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li> <a href="/springTPJSP/menu.do">Accueil</a> </li>
            <li class="dropdown"> 
              <a data-toggle="dropdown" href="#">Catégories <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Conférences</a></li>
                <li><a href="#">Fêtes</a></li>
                <li><a href="#">Musique</a></li>
                <li><a href="#">Offres d'emplois</a></li>
                <li><a href="#">Petites annonces</a></li>
<!--                 <li class="divider"></li> -->
              </ul>
            </li> 
            <li> <a href="<c:url  value="/personne/list.do" />">Membres</a> </li>
          </ul>
          <ul class="nav navbar-nav navbar-right inline-nav">

					<li class="off-right"><a href="#" data-toggle="dropdown">
							<span class="ml10">${principal.username}</span> <i
							class="ti-angle-down ti-caret"></i>
					</a>
						<ul class="dropdown-menu animated fadeInRight">
							<c:url var="urlPersonneUpdate"
								value="/personne/update.do?id=${userSessionId}" />
							<li><a href="${urlPersonneUpdate}"><spring:message
										code="my.account" text="default text" /></a></li>
							<li><a href="<c:url value="/logout" />">Déconnexion</a></li>
						</ul></li>
				</ul>
        </div>
      </nav>
      
	Language :
	<a href="?lang=en">English</a>|
	<a href="?lang=fr">Francais</a>