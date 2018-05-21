<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="<c:url value="/editor/"/>">Панель редактирования </a></li>
					<li class="breadcrumb-item active" aria-current="page"><c:out
							value="${brand}" /></li>
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

		<c:forEach items="${models}" var="model">
			<div class=" col-md-3">
				<div class="card cardModel">
					<div class="imageModel">
						<a href="${brand}/${model.model}"> <img class="card-img-top"
							src="<c:url value="${model.image}" />" height="120"
							alt="${model.model}"></a>
					</div>

					<div class="card-body card-body-model">
						<a href="${brand}/${model.model}" class="btn btn-outline-success">${model.model}</a>
					</div>

				</div>
			</div>
		</c:forEach>

		<div class="col-md-3">
			<div class="card">
				<form:form enctype="multipart/form-data"
					modelAttribute="uploadedFile" method="POST" action="${brand }">

					<div class="form-group">
						<input type="hidden" class="form-control" name="brand"
							value="${brand}">
					</div>

					<div class="imageModel">
						<div class="form-group" style="font-size: 9pt;">
							<label for="exampleFormControlFile1">Выберите
								изображение. (рекомендуемый размер 500 x 375 px и не больше 3
								Mb)</label> <input type="file" name="file" class="form-control-file"
								id="uploadedFile">
						</div>
					</div>

					<div class="card-body-model" align="center"
						style="margin-bottom: -15px;">
						<div class="form-group">
							<label>Название модели</label> <input name="model" type="text"
								class="form-control" id="input"
								style="width: 200px; margin: 0px auto;">
						</div>

						<button type="submit" class="btn btn-primary mb-2">Добавить</button>
					</div>
				</form:form>
			</div>

		</div>
	</div>
</div>

<%@ include file="../include/end-html.jsp"%>