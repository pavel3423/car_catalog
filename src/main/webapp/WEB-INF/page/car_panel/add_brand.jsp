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
						бренд</li>
				</ol>
			</nav>
			
			<c:if test="${msg!=null}">
				<div class="alert alert-success" role="alert">
					<c:out value="${msg}"></c:out>
				</div>
			</c:if>
		</div>



		<div class="col-md-5">
			<div class="form-add-text-image">
				<form:form enctype="multipart/form-data"
					modelAttribute="uploadedFile" method="POST" action="addBrand">

					<div class="form-group">
						<label>Название бренда</label> <input name="brand" type="text"
							class="form-control" id="input">
					</div>

					<div class="form-group">
						<label for="exampleFormControlFile1">Выберите изображение.
							(рекомендуемый размер 500 x 500 px и не больше 3 Mb)</label> <input
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