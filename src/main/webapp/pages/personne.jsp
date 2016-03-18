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

<c:if test="${empty personne.id}">
	<c:set var="sentenceCreateUpdate" value="créer" />
	<c:set var="labelCreateUpdate" value="Créer" />
	<c:set var="textCreateUpdate" value="Création" />
<%-- 	<c:set var="enTetePage" value=  /> --%>
</c:if>
<c:if test="${not empty personne.id}">
	<c:set var="sentenceCreateUpdate" value="mettre à jour" />
	<c:set var="labelCreateUpdate" value="Mettre à jour" />
	<c:set var="textCreateUpdate" value="Mise à jour" />
<%-- 	<c:set var="enTetePage" value= /> --%>
</c:if>
<!-- content wrapper -->
<div class="content-wrap clearfix pt15">
	<div class="col-lg-12 col-md-12 col-xs-12">
		<div class="panel">
			<header class="panel-heading no-b col-lg-offset-2">
				<h1 class="h3 text-primary mt0">
					<c:if test="${empty personne.id}"><spring:message code="new.personne" text="default text" /></c:if>
					<c:if test="${not empty personne.id}"><spring:message code="update.personne" text="default text" /></c:if>
				</h1>

				<div class="panel-body">
					<c:url var="createPersonne" value="/personne/save.do" />
					<form:form action="${createPersonne}" commandName="personne"
						method="POST">
<!-- 						<form:errors path="*" cssClass="errorblock" element="div"></form:errors> -->
						<form:hidden path="id" />
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
							<form:input type="text" class="form-control" id="email" path="email"
								placeholder="exemple@email.com" />
						</div>
						<div class="form-group">
							<label for="password"><spring:message
									code="label.password" text="default text" /></label>
							<form:input type="text" class="form-control" id="password"
								path="password" placeholder="password" />
							<form:errors path="password" class="alert-danger"/>
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
							<a href="<c:url  value="/personne/list.do" />"
								class="btn btn-default btn-outline">Retour</a>
							<button type="submit" class="btn btn-outline btn-primary">${labelCreateUpdate}</button>
						</div>
					</form:form>
				</div>
			</header>
		</div>
	</div>
</div>
</div>
</body>
</html>