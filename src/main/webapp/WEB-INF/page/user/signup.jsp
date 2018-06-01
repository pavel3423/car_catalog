<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<br>
<c:if test="${msg!=null}">
	<div class="alert alert-danger" role="alert">
		<c:out value="${msg}"></c:out>
	</div>
</c:if>

<form class="form-horizontal col-md-4" action="signup" method="POST">
	<fieldset>

		<!-- Form Name -->
		<legend>
			<spring:message code="Signup" />
		</legend>

		<!-- Text input-->
		<div class="form-group">
			<label class=" control-label" for="Login"><spring:message
					code="label.login" /></label> <input id="login" name="login" type="text"
				placeholder="<spring:message code="label.login" />"
				class="form-control input-md">
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="control-label" for="Email"><spring:message
					code="label.email" /></label> <input id="email" name="email" type="text"
				placeholder="<spring:message code="label.email" />"
				class="form-control input-md">
		</div>

		<!-- Password input-->
		<div class="form-group">
			<label class=" control-label" for="Password"><spring:message
					code="label.password" /></label> <input id="password" name="password"
				type="password"
				placeholder="<spring:message code="label.password" />"
				class="form-control input-md">

		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="control-label" for="singlebutton"></label>
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">
				<spring:message code="Signup" />
			</button>
		</div>

	</fieldset>
</form>

<%@ include file="../include/end-html.jsp"%>