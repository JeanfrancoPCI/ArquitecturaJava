package com.arquitecturajava.controlador.accion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.servicios.LibroService;

public class MostrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroService libroService = (LibroService) getBean("libroService");
		List<Libro> listaDeLibros = null;
		String categoria = null;
		List<Categoria> listaDeCategorias = libroService.buscarCategoriasLibros();
		
		if (request.getParameter("categoria") != null) {
			if (request.getParameter("categoria").equals("seleccionar"))
				listaDeLibros = libroService.buscarTodosLosLibros();
			else
				listaDeLibros = libroService.buscarLibrosPorCategoria(request.getParameter("categoria"));

			categoria = request.getParameter("categoria");
		} else {
			categoria = "seleccionar";
			listaDeLibros = libroService.buscarTodosLosLibros();
		}

		request.setAttribute("categoria", categoria);
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "MostrarLibros.jsp";
	}

}
