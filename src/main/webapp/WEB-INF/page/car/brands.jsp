<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<br>
		</div>
		<c:forEach items="${brands}" var="brand">

			<div class="card col-md-2">
				<br> <a href="brand/${brand.brand}"> <img
					class="card-img-top" src="<c:url value="${brand.image }" />"
					alt="${brand.brand}"></a>
				<div class="card-body" align="center">
					<a href="brand/${brand.brand}" class="btn btn-outline-info">${brand.brand}</a>
				</div>
			</div>

		</c:forEach>
	</div>
</div>


<%@ include file="../include/end-html.jsp"%>