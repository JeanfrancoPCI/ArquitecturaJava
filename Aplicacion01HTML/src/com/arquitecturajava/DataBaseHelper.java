package com.arquitecturajava;

<<<<<<< HEAD
=======
import java.lang.reflect.Method;
>>>>>>> 03.DRY_y_JSP
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD

public class DataBaseHelper {
=======
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper<T> {
>>>>>>> 03.DRY_y_JSP
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/arquitecturajava"; 
	private static final String USUARIO = "root";
	private static final String CLAVE = "123456";
	
	public int modificarRegistro (String consultaSQL) {
		Connection conexion = null; 
		Statement sentencia = null; 
		int filasAfectadas = 0;
		
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Error driver " + e.getMessage()); 
		} 
		catch (SQLException e) {
			System.out.println("Error de SQL " + e.getMessage()); 
		} 
		finally {
			if (sentencia != null) {
				try {
					sentencia.close();
				} 
<<<<<<< HEAD
				catch (SQLException e) 
				{
					
				}
=======
				catch (SQLException e) {}
>>>>>>> 03.DRY_y_JSP
			}
			
			if (conexion != null) {
				try {
					conexion.close();
				} 
<<<<<<< HEAD
				catch (SQLException e) {
					
				}
=======
				catch (SQLException e) {}
>>>>>>> 03.DRY_y_JSP
			}
		}
		
		return filasAfectadas;
	}

<<<<<<< HEAD
	public ResultSet seleccionarRegistros(String consultaSQL) {
		Connection conexion = null; 
		Statement sentencia = null; 
		ResultSet filas = null;
		
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL); 
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Error Driver " + e.getMessage()); 
		} 
		catch (SQLException e) {
			System.out.println("Error de SQL " + e.getMessage());
		}
		
		return filas; 
=======
	@SuppressWarnings("unchecked")
	public List<T> seleccionarRegistros(String consultaSQL, Class<?> clase) {
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		List<T> listaDeObjetos = new ArrayList<T>(); 
		
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE); 
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
		
			while (filas.next()) {
				T objeto = (T) Class.forName(clase.getName()).newInstance(); 
				Method[] metodos = objeto.getClass().getDeclaredMethods();

				for (int i = 0; i< metodos.length; i++) {
					if (metodos[i].getName().startsWith("set") ) { 
						metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
					}

					if (objeto.getClass().getName().equals("java.lang.String")) {
						objeto=(T)filas.getString(1);
		 			}
				}
				
				listaDeObjetos.add(objeto);
			}
		} 
		catch (Exception e) {
			System.out.println("Error al seleccionar registros " + e.getCause());
		}
		finally {
			if(sentencia != null) {
				try {
					sentencia.close();
				}
				catch(SQLException e) {}
			}
			
			if(conexion != null) {
				try {
					conexion.close();
				}
				catch(SQLException e) {}
			}
		}
		
		return listaDeObjetos;
>>>>>>> 03.DRY_y_JSP
	}
}
