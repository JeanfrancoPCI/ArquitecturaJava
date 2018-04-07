package com.arquitecturajava.controlador.accion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.factoria.CategoriaDAOFactory;
import com.arquitecturajava.dao.factoria.LibroDAOFactory;

public class MostrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroDAO libroDAO = LibroDAOFactory.getInstance();
		CategoriaDAO categoriaDAO = CategoriaDAOFactory.getInstance();
		List<Libro> listaDeLibros = null;
		String categoria = null;
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		
		if (request.getParameter("categoria") != null) {
			if (request.getParameter("categoria").equals("seleccionar"))
				listaDeLibros = libroDAO.buscarTodos();
			else
				listaDeLibros = libroDAO.buscarPorCategoria(request.getParameter("categoria"));

			categoria = request.getParameter("categoria");
		} else {
			categoria = "seleccionar";
			listaDeLibros = libroDAO.buscarTodos();
		}

		request.setAttribute("categoria", categoria);
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "MostrarLibros.jsp";
	}

}
