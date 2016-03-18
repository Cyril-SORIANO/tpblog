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
	<div>
		<h3>Tu es nouveau, remplis vite ta fiche d'inscription pour nous
			rejoindre!</h3>
		<img height="auto" src="${urlResources}/img/inscrisToi.jpg" alt="">
	</div>
	<br>
	<!-- content wrapper -->
	<div class="content-wrap clearfix pt15">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="panel">
				<div class="panel-body">
					<c:url var="createPersonne" value="/save.do" />
					<form:form action="${createPersonne}" commandName="personne"
						method="POST">
						<!-- 						<form:errors path="*" cssClass="errorblock" element="div"></form:errors> -->
						<form:hidden id="id" path="id" />
						<div class="form-group">
							<label for="nom"> <spring:message code="label.name"
									text="default text" />
							</label>
							<form:input type="text" class="form-control" id="nom" path="nom"
								placeholder="nom" />
						</div>

						<div class="form-group">
							<label for="email"> <spring:message code="label.email"
									text="default text" />
							</label>
							<form:input type="text" class="form-control" id="email"
								path="email" placeholder="exemple@email.com" />
						</div>
						<div class="form-group">
							<label for="password"><spring:message
									code="label.password" text="default text" /></label>
							<form:input type="text" class="form-control" id="password"
								path="password" placeholder="password" />
							<form:errors path="password" class="alert-danger" />
						</div>

						<div class="form-group">
							<label for="role"><spring:message code="choose.role"
									text="default text" /></label>
							<form:select id="role" name="role" path="role.id">
								<form:option value="" label="--- Choisir un Role ---" />
								<form:options items="${roles}" itemValue="id" itemLabel="name" />
							</form:select>
						</div>
						<div class="pull-right">
							<a href="<c:url  value="/login.do" />"
								class="btn btn-default btn-outline">Retour</a>
							<button type="submit" class="btn btn-info"><spring:message code="label.create"
									text="default text" /></button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>