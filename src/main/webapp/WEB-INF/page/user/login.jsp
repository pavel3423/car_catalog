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

<h2>Войти</h2>

<form class="form-horizontal" action="login" method="POST">
	<fieldset>


		<!-- Form Name -->
		<legend>Войти</legend>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="Login">Login</label>
			<div class="col-md-4">
				<input id="login" name="login" type="text" placeholder="Login"
					class="form-control input-md">

			</div>
		</div>

		<!-- Password input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="Password">Password</label>
			<div class="col-md-4">
				<input id="password" name="password" type="password"
					placeholder="Password" class="form-control input-md">
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="button"></label>
			<div class="col-md-4">
				<button id="button" name="button" class="btn btn-success">Войти</button>
			</div>
		</div>

	</fieldset>
</form>

<%@ include file="../include/end-html.jsp"%>