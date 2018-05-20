<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="head-h4">
				<h4>
					<c:out value="${brand}" />
				</h4>
			</div>
		</div>
		<c:forEach items="${models}" var="model">

			<div class="card col-md-2 cardModel">
				<div class="imageModel">
					<a href="${brand}/${model.model}"> <img class="card-img-top"
						src="<c:url value="${model.image}" />" alt="${model.model}"></a>
				</div>

				<div class="card-body card-body-model">
					<a href="${brand}/${model.model}" class="btn btn-outline-success">${model.model}</a>
				</div>

			</div>

		</c:forEach>
	</div>
</div>

<%@ include file="../include/end-html.jsp"%>