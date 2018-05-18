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
		<legend>Регистрация</legend>

		<!-- Text input-->
		<div class="form-group">
			<label class=" control-label" for="Login">Login</label> <input
				id="login" name="login" type="text" placeholder="Login"
				class="form-control input-md">
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="control-label" for="Email">Email</label> <input
				id="email" name="email" type="text" placeholder="Email"
				class="form-control input-md">
		</div>

		<!-- Password input-->
		<div class="form-group">
			<label class=" control-label" for="Password">Password</label> <input
				id="password" name="password" type="password" placeholder="Password"
				class="form-control input-md">

		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="control-label" for="singlebutton"></label>
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">Зарегистрироваться</button>
		</div>

	</fieldset>
</form>

<%@ include file="../include/end-html.jsp"%>