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

<c:url var="loginUrl" value="/login" />
<form class="form-horizontal col-md-4" method="post"
	action="${loginUrl }">
	<fieldset>
		<legend>
			<spring:message code="Login" />
		</legend>
	</fieldset>

	<fieldset>

		<div class="form-group ">
			<label class="control-label" for="Login"> <spring:message
					code="label.login" />:
			</label> <input id="user" class="form-control input-md" type="text"
				name="user" required />
		</div>
		<div class="form-group ">
			<label class="control-label" for="Password"> <spring:message
					code="label.password" />:
			</label> <input id="password" class="form-control input-md" type="password"
				name="password" required />
		</div>

	</fieldset>
	<div class="form-group ">
		<input type="submit" class="btn btn-success"
			value='<spring:message code="Login" />' />
	</div>
</form>

<%@ include file="../include/end-html.jsp"%>