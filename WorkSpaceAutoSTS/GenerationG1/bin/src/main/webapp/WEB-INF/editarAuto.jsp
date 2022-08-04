<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auto</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<c:if test="${msgError!= null}">
			<c:out value="${msgError}"></c:out>
		</c:if>
		<form:form action="/auto/actualizar/${auto.id}" method="post" modelAttribute="auto">
			<form:label path="marca" class="form-label" >Marca:</form:label>
			<form:input path="marca" class="form-control" />
			<br>
			<form:label path="modelo" class="form-label">Modelo:</form:label>
			<form:input path="modelo" class="form-control"/>
			<br>
			<form:label path="velocidad" class="form-label">Velocidad:</form:label>
			<form:input type="number" path="velocidad" class="form-control"/>
			<br>
			<form:label path="color" class="form-label">Color:</form:label>
			<form:input path="color" class="form-control"/>
			<br>
			
			<button type="submit" class="btn btn-outline-warning">Editar Auto</button>
		</form:form>
	</div>
</body>
</html>