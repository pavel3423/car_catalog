<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="row">
	<c:forEach items="${brands}" var="brand">

		<div class="col-md-2" align="center">
			<br> <img src="${brand.image}" width="160" align="middle"
				alt="${brand.brand}"> <a
				href="do?action=models_action&brand=${brand.brand}"
				style="color: black">${brand.brand}</a>
		</div>

	</c:forEach>
</div>

<%@ include file="../include/end-html.jsp"%>