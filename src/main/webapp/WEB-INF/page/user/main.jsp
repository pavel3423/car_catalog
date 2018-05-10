<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<c:out value="${msg}"></c:out>
<div class="row">
	<div class="col-md-12"></div>

	<c:forEach items="${brands}" var="brand">

		<div class="col-md-2" align="center">
			<br> <img src="image/car_brands/${brand.brand}_logo.png"
				width="160" align="middle" alt="${brand.brand}"> <a
				href="do?action=brand_action&brand=${brand.brand}"
				style="color: black">${brand.brand}</a>
		</div>

	</c:forEach>

</div>

<%@ include file="../include/end-html.jsp"%>