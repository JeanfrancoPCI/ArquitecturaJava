package com.arquitecturajava.controlador.accion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Libro;

public class MostrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		List<Libro> listaDeLibros = null;
		String categoria = null;
		List<Libro> listaDeCategorias = Libro.buscarTodasLasCategorias();
		
		if (request.getParameter("categoria") != null) {
			if (request.getParameter("categoria").equals("seleccionar"))
				listaDeLibros = Libro.buscarTodos();
			else
				listaDeLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));

			categoria = request.getParameter("categoria");
		} else {
			categoria = "seleccionar";
			listaDeLibros = Libro.buscarTodos();
		}

		request.setAttribute("categoria", categoria);
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "MostrarLibros.jsp";
	}

}
