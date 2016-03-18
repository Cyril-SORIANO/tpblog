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
<c:if test="${not empty categorie.id}">
	<c:set var="labelCreateUpdate" value="Mettre à Jour" />
</c:if>
<c:if test="${empty categorie.id}">
	<c:set var="labelCreateUpdate" value="Créer" />
</c:if>

<!-- content wrapper -->
<div class="content-wrap clearfix pt15">
	<div class="col-lg-12 col-md-12 col-xs-12">
		<div class="panel">
			<header class="panel-heading no-b col-lg-offset-2">
				<h3>
					<spring:message code="new.categorie" text="default text" />
				</h3>

				<div class="panel-body">
					<c:url var="createCategorie" value="/categorie/save.do" />
					<form:form action="${createCategorie}" commandName="categorie"
						method="POST">
						<!-- 						<form:errors path="*" cssClass="errorblock" element="div"></form:errors> -->
						<form:hidden id="id" path="id" />
						<div class="form-group">
							<label for="name"> <spring:message code="label.name"
									text="default text" />
							</label>
							<form:input type="text" class="form-control" id="name"
								path="name" placeholder="name" />
						</div>

						<div class="form-group">
							<label for="url"> url </label>
							<form:input type="text" class="form-control" id="url" path="url"
								placeholder="www.myblog/name.fr" />
						</div>
						<div class="pull-right">
							<a href="<c:url  value="/categorie/list.do" />"
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