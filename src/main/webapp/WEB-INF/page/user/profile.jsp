<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<br>


<div class="col-12">
	<h4>
		Профиль пользователя
		<c:out value="${user.login }"></c:out>
	</h4>
	<br>
</div>

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

<form action="http://localhost:8080/upload" method="post"
	enctype="multipart/form-data">
	<input name="description" type="text"><br> <input
		name="data" type="file"><br> <input type="submit"><br>
</form>


<%@ include file="../include/end-html.jsp"%>