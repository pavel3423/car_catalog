<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="row">

	<h4>
		<br>
		<c:out value="${brand}" />
	</h4>
	<div class="col-md-12"></div>
	<c:forEach items="${models}" var="model">

		<div class="col-md-2" align="center">
			<br> <img src="${model.image}" width="160" align="middle"
				alt="${model.model}"> <a href="${brand}/${model.model}"
				style="color: black">${model.model}</a>
		</div>

	</c:forEach>

</div>

<%@ include file="../include/end-html.jsp"%>