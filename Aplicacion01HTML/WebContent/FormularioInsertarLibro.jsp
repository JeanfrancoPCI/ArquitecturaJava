<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.arquitecturajava.Libro" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/formato.css" />
<script type="text/javascript" src="js/validacion.js"></script>
<title>Formulario Libro</title>
</head>
<body>
	<form action="InsertarLibro.do" onsubmit="return validacion();">
		<fieldset>
			<legend>Formulario alta libro</legend>
			<p><label for="isbn">ISBN: </label><input type="text" name="isbn" id="isbn" /></p>
			<p><label for="titulo">Titulo: </label><input type="text" name="titulo" id="titulo" /></p>
			<p><label for="categoria">Categoria: </label>
			<select name="categoria">
			    <c:forEach var="categoria" items="${listaDeCategorias}">
					<option value="${categoria}">${categoria}</option>
		        </c:forEach>
		    </select>
		    <br/>
			</p>
			<p><input type="submit" value="Insertar" /></p>
		</fieldset>
	</form>
</body>
</html>