<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.arquitecturajava.Libro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
</head>
<body>
<form action="MostrarLibros.do">
    <select name="categoria">
	    <option value="seleccionar">seleccionar</option>
        <%   	
        	List<String> listaDeCategorias = null;
	        listaDeCategorias = (List<String>) request.getAttribute("listaDeCategorias");
		    for (String categoria: listaDeCategorias) { 
		    	if(categoria.equals(request.getParameter("categoria"))) {
		    %>
		       <option value="<%=categoria%>" selected><%=categoria%></option>
		    <%	}
		    	else {
		    %>
		    	<option value="<%=categoria%>"><%=categoria%></option>		
		    <%
		    	}
        	}
        %>
    </select>
    <input type="submit" value="Filtrar" />
    <br/>
    <%
	    List<Libro> listaDeLibros = (List<Libro>) request.getAttribute("listaDeLibros");
	    for (Libro libro: listaDeLibros) {
	    %>
	    	<%= libro.getIsbn() %> 
	    	<%= libro.getTitulo() %> 
	    	<%= libro.getCategoria() %>
	    	<a href="BorrarLibro.do?isbn=<%=libro.getIsbn() %>">Borrar</a>
	    	<a href="FormularioEditarLibro.do?isbn=<%=libro.getIsbn() %>">Editar</a>
			<br/>
	    <%
	    }
    %>
    <a href="FormularioInsertarLibro.do">Insertar Libro</a>
</form>
</body>
</html>