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
		
		<c:forEach items="${brands}" var="brand">
			<div class=" col-md-3">
				<div class="card">
					<div class="imageBrand">
						<a href="<c:url value="/editor/${brand.brand}"/>"> <img
							class="card-img-top" src="<c:url value="${brand.image}" />"
							alt="${brand.brand}"></a>
					</div>

					<div class="card-body" align="center">
						<a href="<c:url value="/editor/${brand.brand}"/>"
							class="btn btn-outline-info">${brand.brand}</a>
					</div>
				</div>
			</div>
		</c:forEach>

		<div class="col-md-3">
			<div class="card">
				<form:form enctype="multipart/form-data"
					modelAttribute="uploadedFile" method="POST" action="editor">
					<div class="imageBrand">
						<div class="form-group" style="font-size: 9pt;">
							<label for="exampleFormControlFile1">Выберите
								изображение. (рекомендуемый размер 500 x 500 px и не больше 3
								Mb)</label> <input type="file" name="file" class="form-control-file"
								id="uploadedFile">
						</div>
					</div>
					
					<div class="card-body" align="center" style="margin-bottom: -40px;">
						<div class="form-group" style="margin-top: -70px">
							<label>Название бренда</label> <input name="brand" type="text"
								class="form-control" id="input">
						</div>
						<button type="submit" class="btn btn-primary mb-2">Добавить</button>
					</div>
				</form:form>
			</div>
		</div>
		
	</div>
</div>



<%@ include file="../include/end-html.jsp"%>