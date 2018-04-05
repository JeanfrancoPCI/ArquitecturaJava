<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arquitecturajava.bo.Libro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
</head>
<body>
<form name="filtroCategoria" action="MostrarLibros.do">
    <select name="categoria">
	    <option value="seleccionar">seleccionar</option>
        <c:forEach var="categoria2" items="${listaDeCategorias}">
			<option value="${categoria2}" ${categoria == categoria2 ? 'selected' : ''}>${categoria2}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Filtrar" />
</form>
<c:forEach var="libro" items="${listaDeLibros}">
	${libro.isbn} ${libro.titulo} ${libro.categoria}
	<a href="BorrarLibro.do?isbn=${libro.isbn}">Borrar</a>
	<a href="FormularioEditarLibro.do?isbn=${libro.isbn}">Editar</a>
	<br />
</c:forEach>
<a href="FormularioInsertarLibro.do">Insertar Libro</a>
</body>
</html>