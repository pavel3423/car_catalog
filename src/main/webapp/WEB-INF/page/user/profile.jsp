<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="col-12">
	<div class="head-h4">
		<h4>
			Профиль пользователя
			<c:out value="${user.login }" />
		</h4>
	</div>
</div>

<a href='<c:url value="/editor" />'>Редактор</a>

<form class="form-horizontal col-md-4" action="profile" method="POST">
	<fieldset>
		<!-- Form Name -->
		<legend>Изменить данные</legend>

		<div class="form-group ">
			<label class="control-label" for="Email">Email</label> <input
				id="Email" name="Email" type="text" value="${user.email}"
				class="form-control input-md">

		</div>

		<!-- Password input-->
		<div class="form-group">
			<label class=" control-label" for="Password">Пароль</label> <input
				id="Password" name="Password" type="password" placeholder="******"
				class="form-control input-md">

		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="control-label" for="button"></label>
			<button id="button" name="button" class="btn btn-success">Сохранить
				изменения</button>
		</div>

	</fieldset>
</form>

<%@ include file="../include/end-html.jsp"%>