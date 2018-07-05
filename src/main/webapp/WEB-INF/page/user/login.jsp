<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<br>
<c:if test="${msg!=null}">
	<div class="alert alert-danger" role="alert">
		<c:out value="${msg}"></c:out>
	</div>
</c:if>

<form:form class="form-horizontal col-md-4" method="post" action="login">

	<legend>
		<spring:message code="Login" />
	</legend>

	<fieldset>
		<div class="form-group ">
			<form:label class="control-label" for="Login" path="login">
				<spring:message code="label.login" />:</form:label>
			<form:input class="form-control input-md" path="login" />
		</div>
		<div class="form-group ">
			<form:label class="control-label" for="Password" path="password">
				<spring:message code="label.password" />:</form:label>
			<form:password class="form-control input-md" path="password" />
		</div>

	</fieldset>
	<div class="form-group ">
		<input class="btn btn-success" type="submit"
			value="<spring:message code="Login" />" />
	</div>
</form:form>

<%@ include file="../include/end-html.jsp"%>