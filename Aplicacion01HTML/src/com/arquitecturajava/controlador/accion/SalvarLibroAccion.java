package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.factoria.CategoriaDAOFactory;
import com.arquitecturajava.dao.factoria.LibroDAOFactory;

public class SalvarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		CategoriaDAO categoriaDAO = CategoriaDAOFactory.getInstance();
		LibroDAO libroDAO = LibroDAOFactory.getInstance();
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria"); 
		Categoria categoria2 = categoriaDAO.buscarPorClave(categoria);
		Libro libro = new Libro(isbn, titulo, categoria2); 
		libroDAO.salvar(libro);
		return "MostrarLibros.do";
	}
}
