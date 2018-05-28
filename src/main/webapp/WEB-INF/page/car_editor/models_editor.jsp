<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="<c:url value="/editor"/>">Панель
							редактирования </a></li>
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

		<div class="col-md-12">
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#exampleModalCenterEdit">Изменить бренд</button>
			<button type="button" class="btn btn-danger" data-toggle="modal"
				data-target="#exampleModalCenter">Удалить бренд и все
				связанные с ним автомобили</button>
		</div>

		<div class="modal fade" id="exampleModalCenterEdit" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Редактирование
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<c:url var="edit_url" value="/editor/${brand}/edit" />
					<form:form enctype="multipart/form-data"
						modelAttribute="uploadedFile" method="POST" action="${edit_url }">
						<div class="modal-body">
							<label>Название бренда</label> <input name="newBrand" type="text"
								class="form-control" id="input" value="${brand}"> <label
								for="exampleFormControlFile1">Выберите изображение.
								(рекомендуемый размер 500 x 500 px и не больше 3 Mb)</label> <input
								type="file" name="file" class="form-control-file"
								id="uploadedFile">
						</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Отмена</button>
							<button type="submit" name="brand" value="${brand}"
								class="btn btn-success">Сохранить</button>

						</div>
					</form:form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Внимание!
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						Это приведёт к удалению всех автомобилей этого бренда без
						возможности восстановления<br> Вы действительно хотите
						удалить ${brand }?
					</div>
					<div class="modal-footer">
						<form action='<c:url value="/editor/${brand}/delete"/>'
							method="POST">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Отмена</button>
							<button type="submit" class="btn btn-danger">Удалить</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<c:forEach items="${models}" var="model">
			<div class=" col-md-3">
				<div class="card cardModel">
					<div class="imageModel">
						<a href="<c:url value="/editor/${brand}/${model.model }"/>"> <img
							class="card-img-top" src="<c:url value="${model.image}" />"
							height="120" alt="${model.model}"></a>
					</div>

					<div class="card-body card-body-model">
						<a href="<c:url value="/editor/${brand}/${model.model }"/>"
							class="btn btn-outline-success">${model.model}</a>
					</div>

				</div>
			</div>
		</c:forEach>

		<div class="col-md-3">
			<div class="card">
				<c:url var="add_url" value="/editor/${brand }" />
				<form:form enctype="multipart/form-data"
					modelAttribute="uploadedFile" method="POST" action="${add_url }">

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