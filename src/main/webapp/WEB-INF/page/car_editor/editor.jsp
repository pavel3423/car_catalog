<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item active" aria-current="page"><spring:message
							code="Editing panel" /></li>
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
							class="card-img-top"
							src="<c:url value="/image/${brand.image}" />"
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
				<c:url var="edit_url" value="/editor" />
				<form:form enctype="multipart/form-data"
					modelAttribute="uploadedFile" action='${edit_url }' method="POST">
					<div class="imageBrand">
						<div class="form-group" style="font-size: 9pt;">
							<label for="exampleFormControlFile1"><spring:message
									code="Select an image. (the recommended size is 500 x 500 px and not more than 3 MB)" /></label>
							<input type="file" name="file" class="form-control-file"
								id="uploadedFile">
						</div>
					</div>

					<div class="card-body" align="center" style="margin-bottom: -40px;">
						<div class="form-group" style="margin-top: -70px">
							<label><spring:message code="Brand name" /></label> <input
								name="brand" type="text" class="form-control" id="input">
						</div>
						<button type="submit" class="btn btn-primary mb-2">
							<spring:message code="Upload" />
						</button>
					</div>
				</form:form>
			</div>
		</div>

	</div>
</div>



<%@ include file="../include/end-html.jsp"%>