<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="<c:url value="/editor"/>">Панель
							редактирования </a></li>
					<li class="breadcrumb-item"><a
						href="<c:url value="/editor/${brand }"/>"><c:out
								value="${brand}" /></a></li>
					<li class="breadcrumb-item active" aria-current="page"><c:out
							value="${model}" /></li>
				</ol>
			</nav>

			<c:if test="${msg!=null}">
				<div class="alert alert-success" role="alert">
					<c:out value="${msg}"></c:out>
				</div>
			</c:if>

			<c:if test="${error!=null}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${error}"></c:out>
				</div>
			</c:if>

		</div>

		<div class="col-md-12">
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#exampleModalCenterEditCar">Изменить параметры
				автомобиля</button>
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#exampleModalCenterEdit">Изменить карточку
				модели</button>
			<button type="button" class="btn btn-danger" data-toggle="modal"
				data-target="#exampleModalCenter">Удалить модель и
				связанный с ней автомобиль</button>
		</div>

		<div class="modal fade" id="exampleModalCenterEditCar" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document"
				style="max-width: 1250px;">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Редактирование
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<c:url var="edit_car_url"
						value="/editor/${brand }/${model }/carEdit" />
					<form:form enctype="multipart/form-data"
						modelAttribute="uploadedFile" method="POST"
						action="${edit_car_url }">
						<div class="modal-body">
							<div class="col-12">
								<label for="exampleFormControlFile1">Выберите
									изображение. (рекомендуемый размер 1920 x 600 px и не больше 3
									Mb)</label> <input type="file" name="file" class="form-control-file"
									id="uploadedFile"> <br>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Год</th>
											<th>Цена от, $</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input id="textinput" name="year" type="text"
												value="${car.year }" class="form-control input-md"></td>
											<td><input id="textinput" name="price" type="text"
												value="${car.price }" class="form-control input-md"></td>
										</tr>
									</tbody>
								</table>
								<table class="table table-bordered">

									<thead>
										<tr>
											<th>Тип кузова</th>
											<th>Длина, мм</th>
											<th>Ширина, мм</th>
											<th>Высота, мм</th>
											<th>База, мм</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input id="textinput" name="bodyType" type="text"
												value="${car.bodyType }" class="form-control input-md"></td>
											<td><input id="textinput" name="length" type="text"
												value="${car.length }" class="form-control input-md"></td>
											<td><input id="textinput" name="width" type="text"
												value="${car.width }" class="form-control input-md"></td>
											<td><input id="textinput" name="height" type="text"
												value="${car.height }" class="form-control input-md"></td>
											<td><input id="textinput" name="base" type="text"
												value="${car.base }" class="form-control input-md"></td>
										</tr>
									</tbody>
									<thead>
										<tr>
											<th>Кол-во дверей</th>
											<th>Клиренс, мм</th>
											<th>Багажник, л</th>
											<th>Объем бака, л</th>
											<th>Кол-во мест</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input id="textinput" name="numberOfDoors"
												type="text" value="${car.numberOfDoors }"
												class="form-control input-md"></td>
											<td><input id="textinput" name="clearance" type="text"
												value="${car.clearance }" class="form-control input-md"></td>
											<td><input id="textinput" name="trunk" type="text"
												value="${car.trunk }" class="form-control input-md"></td>
											<td><input id="textinput" name="volumeOfTheTank"
												type="text" value="${car.volumeOfTheTank }"
												class="form-control input-md"></td>
											<td><input id="textinput" name="numberOfPlaces"
												type="text" value="${car.numberOfPlaces }"
												class="form-control input-md"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Отмена</button>
							<button type="submit" name="brand" value="${brand}"
								class="btn btn-success">Сохранить</button>

						</div>
					</form:form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="exampleModalCenterEdit" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Редактирование
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<c:url var="edit_model_url"
						value="/editor/${brand }/${model }/edit" />
					<form:form enctype="multipart/form-data"
						modelAttribute="uploadedFile" method="POST"
						action="${edit_model_url }">
						<div class="modal-body">
							<label>Название модели</label> <input name="newModel" type="text"
								class="form-control" id="input" value="${model }"> <label
								for="exampleFormControlFile1">Выберите изображение.
								(рекомендуемый размер 500 x 375 px и не больше 3 Mb)</label> <input
								type="file" name="file" class="form-control-file"
								id="uploadedFile">
						</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Отмена</button>
							<button type="submit" name="brand" value="${brand}"
								class="btn btn-success">Сохранить</button>

						</div>
					</form:form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Внимание!
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						Это приведёт к удалению автомобиля и карточки модели<br> Вы
						действительно хотите удалить ${brand } ${model }?
					</div>
					<div class="modal-footer">
						<form action='<c:url value="/editor/${brand }/${model }/delete"/>'
							method="POST">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Отмена</button>
							<button type="submit" class="btn btn-danger">Удалить</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<h4>
				<br>
				<c:out value="${car.year}" />
				<c:out value="${brand}" />
				<c:out value="${model}" />
			</h4>
		</div>

		<div class="col-md-6">
			<h4 align="right">
				<br> Цена от
				<c:out value="${car.price }" />
				$
			</h4>
		</div>

		<div class="col-md-12">
			<div id="carouselExampleFade" class="carousel slide carousel-fade"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100"
							src='<c:url value="/image/${car.image}" />' alt="First slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleFade"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleFade"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>

		<div class="col-12">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Тип кузова</th>
						<th>Длина, мм</th>
						<th>Ширина, мм</th>
						<th>Высота, мм</th>
						<th>База, мм</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${car.bodyType }</td>
						<td>${car.length }</td>
						<td>${car.width }</td>
						<td>${car.height }</td>
						<td>${car.base }</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th>Кол-во дверей</th>
						<th>Клиренс, мм</th>
						<th>Багажник, л</th>
						<th>Объем бака, л</th>
						<th>Кол-во мест</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${car.numberOfDoors }</td>
						<td>${car.clearance }</td>
						<td>${car.trunk }</td>
						<td>${car.volumeOfTheTank }</td>
						<td>${car.numberOfPlaces }</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</div>
<%@ include file="../include/end-html.jsp"%>