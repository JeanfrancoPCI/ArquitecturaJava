package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;

public class InsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroDAO libroDAO = new LibroDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria"); 
		Categoria categoria2 = categoriaDAO.obtenerPorId(categoria);
		Libro libro = new Libro(isbn, titulo, categoria2); 
		libroDAO.insertar(libro);
		return "MostrarLibros.do";
	}

}
