package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;

public class InsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria"); 
		Categoria categoria2 = Categoria.obtenerPorId(categoria);
		Libro libro = new Libro(isbn, titulo, categoria2); 
		libro.insertar();
		return "MostrarLibros.do";
	}

}
