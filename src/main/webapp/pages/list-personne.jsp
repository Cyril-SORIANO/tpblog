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

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="app bg-default horizontal-layout">

				<table class="table table-striped list no-m">
					<tbody>
						<tr>
							<th>Id</th>
							<th><spring:message code="label.name"
									text="default text" /></th>
							<th>Email</th>
							<th>Role</th>
							<th>Actions</th>
						</tr>

						<c:forEach items="${personnes}" var="personne">
							<c:url var="urlPersonneDelete"
								value="/personne/delete.do?id=${personne.id}" />
							<c:url var="urlPersonneUpdate"
								value="/personne/update.do?id=${personne.id}" />
							<tr>
								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlPersonneUpdate}">${personne.id }</a>
									</sec:authorize></td>
									<td>${personne.nom}</td>
								<td>${personne.email}</td>
								
								<td>${personne.role.name}</td>
								
								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlPersonneDelete}">delete</a></td>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>