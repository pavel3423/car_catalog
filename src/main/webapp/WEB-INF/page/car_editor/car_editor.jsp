<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="<c:url value="/"/>">К
							списку производителей</a></li>
					<li class="breadcrumb-item" aria-current="page"><a
						href="<c:url value="/"/><c:out
							value="${brand}" />"><c:out
								value="${brand}" /></a></li>
					<li class="breadcrumb-item active" aria-current="page"><c:out
							value="${model}" /></li>
				</ol>
			</nav>
		</div>

		<h4>
			<br>
			<c:out value="${brand}" />
			<c:out value="${model}" />
		</h4>

		<c:out value="${cars}" />

	</div>
</div>
<%@ include file="../include/end-html.jsp"%>