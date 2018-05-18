<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h4>
				<br>
				<c:out value="${brand}" />
				<br>
			</h4>
		</div>
		<c:forEach items="${models}" var="model">

			<div class="card col-md-2 cardModel">
				<div class="imageModel">
					<a href="${brand}/${model.model}"> <img class="card-img-top"
						src="${model.image}" alt="${model.model}"></a>
				</div>

				<div class="card-body card-body-model">
					<a href="${brand}/${model.model}" class="btn btn-outline-success">${model.model}</a>
				</div>

			</div>

		</c:forEach>
	</div>
</div>

<%@ include file="../include/end-html.jsp"%>