<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.arquitecturajava.DataBaseHelper" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arquitecturajava.Libro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
</head>
<body>
<form action="MostrarLibros.jsp">
    <select name="categoria">
	    <option value="seleccionar">seleccionar</option>
        <%
	        List<String> listaDeCategorias = null;
        	listaDeCategorias = Libro.buscarTodasLasCategorias();
	    	for (String categoria: listaDeCategorias) { 
        %>
        <option value="<%=categoria%>"><%=categoria%></option>
        <%
        	}
        %>
    </select>
    <input type="submit" value="Filtrar" />
    <br/>
    <%
    	List<Libro> listaDeLibros = null;
    	if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar"))
    		listaDeLibros = Libro.buscarTodos();
    	else 
    		listaDeLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));
   
    	for (Libro libro: listaDeLibros) {
    	%>
    		<%= libro.getIsbn() %> 
    		<%= libro.getTitulo() %> 
    		<%= libro.getCategoria() %>
    		<a href="BorrarLibro.jsp?isbn=<%=libro.getIsbn() %>">Borrar</a>
    		<a href="FormularioEditarLibro.jsp?isbn=<%=libro.getIsbn() %>">Editar</a>
			<br/>
    	<%
    	}
    %>
    <a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</form>
</body>
</html>