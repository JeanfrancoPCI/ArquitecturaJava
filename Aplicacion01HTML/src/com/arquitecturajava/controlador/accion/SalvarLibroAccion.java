package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.jpa.CategoriaDAOJPAImpl;
import com.arquitecturajava.dao.jpa.LibroDAOJPAImpl;

public class SalvarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria"); 
		Categoria categoria2 = categoriaDAO.buscarPorClave(categoria);
		Libro libro = new Libro(isbn, titulo, categoria2); 
		libroDAO.salvar(libro);
		return "MostrarLibros.do";
	}
}
