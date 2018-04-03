package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
	
	public static Accion getAccion(String tipo) {
		Accion accion = null;
		
		switch (tipo) {
			case "/MostrarLibros.do":
				accion = new MostrarLibrosAccion();
				break;
			case "/FormularioInsertarLibro.do":
				accion = new FormularioInsertarLibro();
				break;
			case "/InsertarLibro.do":
				accion = new InsertarLibroAccion();
				break;
			case "/BorrarLibro.do":
				accion = new BorrarLibroAccion();
				break;
			case "/FormularioEditarLibro.do":
				accion = new FormularioEditarLibroAccion();
				break;
			case "/SalvarLibro.do":
				accion = new SalvarLibroAccion();
				break;
		}
		
		return accion;
	}
}
