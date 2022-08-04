<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<div>
		<!--pasar informacion desde la vista a una url(action)  -->
		<!--method "get" es por default, los parametros se ven en la ruta  -->
		<!--method "post", lo parametros no se ven, van ocultos  -->
		<form action="/registro/usuario" method="post"> 
			<label for="nombre"> Nombre: </label>
			<input type="text" id="nombre" name="gato">
			<br><!-- salto de linea -->
			<label for="apellidoX"> Apellido: </label>
			<input type="text" id="apellidoX" name="apellido">
			<br>
			<label for="email"> email: </label>
			<input type="email" id="email" name="email">
			<br>
			<!-- submit para el envio de informacion -->
			<input type="submit" value="Registrar"> 
			<input type="button" value="Enviar"> 
		</form>
	</div>
</body>
</html>