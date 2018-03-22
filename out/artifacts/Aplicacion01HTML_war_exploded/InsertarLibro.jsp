<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.arquitecturajava.DataBaseHelper" %>

<%
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	//Realizo la consulta usando DBHelper y el código queda simplificado
	String consultaSQL = "insert into Libros (isbn, titulo, categoria) values ";
	consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
	DataBaseHelper db = new DataBaseHelper();
	int filas = db.modificarRegistro(consultaSQL);
	response.sendRedirect("MostrarLibros.jsp");
%>
	
	
