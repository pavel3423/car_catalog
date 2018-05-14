<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<br>
<c:if test="${msg!=null}">
	<div class="alert alert-danger" role="alert">
		<c:out value="${msg}"></c:out>
	</div>
</c:if>

<form class="form-horizontal" action="signup" method="POST">
	<fieldset>

		<!-- Form Name -->
		<legend>Регистрация</legend>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="Login">Login</label>
			<div class="col-md-4">
				<input id="login" name="login" type="text" placeholder="Login"
					class="form-control input-md">

			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="Email">Email</label>
			<div class="col-md-4">
				<input id="email" name="email" type="text" placeholder="Email"
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
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-4">
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Зарегистрироваться</button>
			</div>
		</div>

	</fieldset>
</form>

<%@ include file="../include/end-html.jsp"%>