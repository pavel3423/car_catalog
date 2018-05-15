<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="row">

	<h4>
		<br>
		<c:out value="${brand}" />
		<c:out value="${model}" />
	</h4>

	<c:out value="${cars}" />

</div>

<%@ include file="../include/end-html.jsp"%>