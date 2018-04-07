package com.arquitecturajava.controlador.accion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroDAO libroDAO =  new LibroDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		String isbn = request.getParameter("isbn");
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		Libro libro = libroDAO.buscarPorClave(isbn);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);
		return "FormularioEditarLibro.jsp";
	}

}
