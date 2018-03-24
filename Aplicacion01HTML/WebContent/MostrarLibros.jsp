<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.arquitecturajava.DataBaseHelper" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arquitecturajava.Libro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Libros</title>
</head>
<body>
<<<<<<< HEAD
<%
	ResultSet rs = null;
	try {
		String consultaSQL = "select isbn,titulo,categoria from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		rs = helper.seleccionarRegistros(consultaSQL);
		while (rs.next()) { 
%>
	<%=		rs.getString("isbn")			%> 
	<%=		rs.getString("titulo")		%> 
	<%=		rs.getString("categoria")	%>
	<br/>
<% 		}
	}
	catch (SQLException e) {
		System.out.println("Error accediendo a la base de datos " + e.getMessage());
	}
	finally {
		//6
		if (rs != null) {
			try {
				rs.close();
			} 
			catch (SQLException e) {
				System.out.println("Error cerrando el resultset " + e.getMessage());
			}
		}
	}
%>
<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
=======
    <select name="categoria">
	    <option value="seleccionar">seleccionar</option>
        <%
	        List<String> listaDeCategorias = null;
        	listaDeCategorias = Libro.buscarTodasLasCategorias();
	    	for(String categoria: listaDeCategorias) { 
        %>
        <option value="<%=categoria%>"><%=categoria%></option>
        <%
        	}
        %>
    </select>
    <br/>
    <%
    	List<Libro> listaDeLibros = null;
    	listaDeLibros = Libro.buscarTodos();
    	for(Libro libro: listaDeLibros) {
    	%>
    		<%= libro.getIsbn() %> 
    		<%= libro.getTitulo() %> 
    		<%= libro.getCategoria() %>
			<br/>
    	<%
    	}
    %>
    <a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
>>>>>>> 03.DRY_y_JSP
</body>
</html>