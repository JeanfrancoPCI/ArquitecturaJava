<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.arquitecturajava.bo.Libro" %>
<%@ page import="java.util.List" %>
<% Libro libro = Libro.buscarPorClave(request.getParameter("isbn")); %>
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
				<input type="text" id="isbn" name="isbn" value="<%=libro.getIsbn() %>"/>
			</p>
			<p>
				<label for="titulo">Título: </label>
				<input type="text" id="titulo" name="titulo" value="<%=libro.getTitulo() %>"/>
			</p>
			<p>
				<label for="categoria">Categoría: </label>
				<select name="categoria">
			        <c:forEach var="categoria2" items="${listaDeCategorias}">
						<option value="${categoria2.id}" ${categoria == categoria2.id ? 'selected' : ''}>
							${categoria2.descripcion}</option>
			        </c:forEach>
			    </select>
				<br />
			</p>
			<p><input type="submit" value="Salvar" /></p>
		</fieldset>
	</form>
</body>
</html>