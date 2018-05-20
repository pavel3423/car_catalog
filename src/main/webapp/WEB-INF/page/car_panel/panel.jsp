<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item active" aria-current="page">Панель
						редактирования</li>
				</ol>
			</nav>
		</div>

		<div class="col-md-12 ">
			<div class="panel-elements">
				<h5>Бренд</h5>
				<a role="button" class="btn btn-primary btn-sm"
					href='<c:url value="/panel/addBrand" />'>Добавить</a> <a
					role="button" class="btn btn-secondary btn-sm"
					href="<c:url value="/panel/editBrand" />">Изменить</a>
			</div>
		</div>

		<div class="col-md-12">
			<div class="panel-elements">
				<h5>Модель</h5>
				<a role="button" class="btn btn-primary btn-sm"
					href="<c:url value="/panel/addModel" />">Добавить</a> <a
					role="button" class="btn btn-secondary btn-sm"
					href="<c:url value="/panel/editModel" />">Изменить</a>
			</div>
		</div>

		<div class="col-md-12">
			<div class="panel-elements">
				<h5>Автомобиль</h5>
				<a role="button" class="btn btn-primary btn-sm"
					href="<c:url value="/panel/addCar" />">Добавить</a> <a
					role="button" class="btn btn-secondary btn-sm"
					href="<c:url value="/panel/editCar" />">Изменить</a>
			</div>
		</div>
	</div>
</div>

<%@ include file="../include/end-html.jsp"%>