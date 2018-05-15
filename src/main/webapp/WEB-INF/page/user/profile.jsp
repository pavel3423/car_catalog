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

<form class="form-horizontal" action="do?command=Profile" method="POST">
	<fieldset>
		<!-- Form Name -->
		<legend>Изменить данные</legend>

		<div class="form-group">
			<label class="col-md-4 control-label" for="Email">Email</label>
			<div class="col-md-4">
				<input id="Email" name="Email" type="text" value="${user.email}"
					class="form-control input-md">

			</div>
		</div>

		<!-- Password input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="Password">Пароль</label>
			<div class="col-md-4">
				<input id="Password" name="Password" type="password"
					placeholder="******" class="form-control input-md">
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="button"></label>
			<div class="col-md-4">
				<button id="button" name="button" class="btn btn-success">Сохранить
					изменения</button>
			</div>
		</div>

	</fieldset>
</form>


<%@ include file="../include/end-html.jsp"%>