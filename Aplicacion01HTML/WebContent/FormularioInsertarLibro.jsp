<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	<form action="InsertarLibro.jsp" onsubmit="return validacion();">
		<fieldset>
			<legend>Formulario alta libro</legend>
			<p><label for="isbn">ISBN: </label><input type="text" name="isbn" id="isbn" /></p>
			<p><label for="titulo">Titulo: </label><input type="text" name="titulo" id="titulo" /></p>
			<p><label for="categoria">Categoria: </label>
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
			</p>
			<p><input type="submit" value="Insertar" /></p>
		</fieldset>
	</form>
</body>
</html>