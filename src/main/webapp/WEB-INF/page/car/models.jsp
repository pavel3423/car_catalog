<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="<c:url value="/"/>"><spring:message
								code="To the list of manufacturers" /></a></li>
					<li class="breadcrumb-item active" aria-current="page"><c:out
							value="${brand}" /></li>
				</ol>
			</nav>
		</div>
		<c:forEach items="${models}" var="model">
			<div class=" col-md-3">
				<div class="card cardModel">
					<div class="imageModel">
						<a href="<c:url value="/${brand}/${model.model }"/>"> <img
							class="card-img-top"
							src="<c:url value="/image/${model.image}" />" height="120"
							alt="${model.model}"></a>
					</div>

					<div class="card-body card-body-model">
						<a href="<c:url value="/${brand}/${model.model }"/>"
							class="btn btn-outline-success">${model.model}</a>
					</div>

				</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="../include/end-html.jsp"%>