<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/formato.css" />
<script type="text/javascript" src="js/validacion.js"></script>
<title>Editar Libro</title>
</head>
<body>
	<form id="formularioEdicion" action="SalvarLibro.do">
		<fieldset>
			<legend>Formulario alta libro</legend>
			<p>
				<label for="isbn">ISBN: </label>
				<input type="text" id="isbn" name="isbn" value="${libro.isbn}"/>
			</p>
			<p>
				<label for="titulo">Título: </label>
				<input type="text" id="titulo" name="titulo" value="${libro.titulo}"/>
			</p>
			<p>
				<label for="categoria">Categoría: </label>
				<select name="categoria">
			        <c:forEach var="categoria" items="${listaDeCategorias}">
						<option value="${categoria.id}" ${libro.categoria.id == categoria.id ? 'selected' : ''}>
							${categoria.descripcion}</option>
			        </c:forEach>
			    </select>
				<br />
			</p>
			<p><input type="submit" value="Salvar" /></p>
		</fieldset>
	</form>
</body>
</html>