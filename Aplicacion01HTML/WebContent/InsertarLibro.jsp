<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
    
<%@ page import="com.arquitecturajava.DataBaseHelper" %>

=======
<%@ page import="com.arquitecturajava.Libro" %>
>>>>>>> 03.DRY_y_JSP
<%
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
<<<<<<< HEAD
	
	//Realizo la consulta usando DBHelper y el código queda simplificado
	String consultaSQL = "insert into Libros (isbn, titulo, categoria) values ";
	consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
	DataBaseHelper db = new DataBaseHelper();
	int filas = db.modificarRegistro(consultaSQL);
=======
	Libro libro = new Libro(isbn, titulo, categoria);
	libro.insertar();
>>>>>>> 03.DRY_y_JSP
	response.sendRedirect("MostrarLibros.jsp");
%>
	
	
