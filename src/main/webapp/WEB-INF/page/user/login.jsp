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

<form:form class="form-horizontal" method="post" action="login">

	<legend>Войти</legend>

	<fieldset>
		<div class="form-group col-4">
			<form:label class="control-label" for="Login" path="login">Login:</form:label>
			<form:input class="form-control input-md" path="login" />
		</div>
		<div class="form-group col-4">
			<form:label class="control-label" for="Password" path="password">Password:</form:label>
			<form:password class="form-control input-md" path="password" />
		</div>

	</fieldset>
	<div class="form-group col-4">
		<input class="btn btn-success" type="submit" value="Войти" />
	</div>
</form:form>

<%@ include file="../include/end-html.jsp"%>