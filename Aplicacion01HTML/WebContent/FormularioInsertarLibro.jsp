<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.arquitecturajava.DataBaseHelper" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
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
		            ResultSet rs = null;
		            try {
		                String consultaSQL = "select distinct(categoria) from Libros";
		                DataBaseHelper helper = new DataBaseHelper();
		                rs = helper.seleccionarRegistros(consultaSQL);
		
		                while(rs.next()) { 
		        %>
		        <option value="<%= rs.getString("categoria") %>"><%=rs.getString("categoria")%></option>
		        <%
		                }
		            }
		            catch (SQLException e) {
		                System.out.println("Error accediendo a la base de datos " + e.getMessage());
		            }
		            finally {
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
		    </select>
		    <br/>
			</p>
			<p><input type="submit" value="Insertar" /></p>
		</fieldset>
	</form>
</body>
</html>