<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>
<div class="container">
	<div class="row">

		<div class="col-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="<c:url value="/panel/"/>">Панель
							редактирования</a></li>
					<li class="breadcrumb-item active" aria-current="page">Добавить
						модель</li>
				</ol>
			</nav>

			<c:if test="${msg!=null}">
				<div class="alert alert-success" role="alert">
					<c:out value="${msg}"></c:out>
				</div>
			</c:if>

			<c:if test="${error!=null}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${error}"></c:out>
				</div>
			</c:if>

		</div>

		<div class="col-md-5">
			<div class="form-add-text-image">
				<form:form enctype="multipart/form-data"
					modelAttribute="uploadedFile" method="POST" action="addModel">

					<div class="form-group">
						<label>Название бренда</label> <select class="form-control"
							name="brand">
							<c:forEach items="${brands}" var="brand">
								<option>${brand.brand }</option>
							</c:forEach>

						</select>
					</div>

					<div class="form-group">
						<label>Название модели</label> <input name="model" type="text"
							class="form-control" id="input">
					</div>

					<div class="form-group">
						<label for="exampleFormControlFile1">Выберите изображение.
							(рекомендуемый размер 500 x 375 px и не больше 3 Mb)</label> <input
							type="file" name="file" class="form-control-file"
							id="uploadedFile">
					</div>
					<button type="submit" class="btn btn-primary mb-2">Добавить</button>
				</form:form>

			</div>
		</div>

	</div>
</div>

<%@ include file="../include/end-html.jsp"%>