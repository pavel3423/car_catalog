<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<c:out value="${msg}"></c:out>
<div class="row">
	<div class="col-md-12"></div>
	
	<c:forEach items="${brands}" var="brand">
	
		<br>
		<br>
		<div class="col-md-2">
			<a href="#">${brand.brand}</a>
		</div>

	</c:forEach>

</div>

<%@ include file="../include/end-html.jsp"%>