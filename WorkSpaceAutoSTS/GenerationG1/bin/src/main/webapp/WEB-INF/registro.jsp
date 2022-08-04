<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<div>
		<c:if test="${msgError!= null}">
			<c:out value="${msgError}"></c:out>
		</c:if>
		
		<form:form action="/registro/usuario" method="post" modelAttribute="usuario">
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre"/>
			<br>
			<form:label path="apellido">Apellido:</form:label>
			<form:input path="apellido"/>
			<br>
			<form:label path="edad">Edad:</form:label>
			<form:input type="number" path="edad"/>
			<br>
			<form:label path="email">Email:</form:label>
			<form:input type="email" path="email"/>
			<br>
			<form:label path="password">Password:</form:label>
			<form:input type="password" path="password"/>
			<br>
			<form:label path="passwordConfirmacion">Confirmar Password:</form:label>
			<form:input type="password" path="passwordConfirmacion"/>
			<br>
			
			
			<input type="submit" value="Registrar">
		</form:form>
	</div>
</body>
</html>