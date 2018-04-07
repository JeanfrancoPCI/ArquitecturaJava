package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.factoria.DAOAbstractFactory;
import com.arquitecturajava.dao.factoria.DAOFactory;

public class SalvarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		LibroDAO libroDAO = factoria.getLibroDAO();
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria"); 
		Categoria categoria2 = categoriaDAO.buscarPorClave(categoria);
		Libro libro = new Libro(isbn, titulo, categoria2); 
		libroDAO.salvar(libro);
		return "MostrarLibros.do";
	}
}
