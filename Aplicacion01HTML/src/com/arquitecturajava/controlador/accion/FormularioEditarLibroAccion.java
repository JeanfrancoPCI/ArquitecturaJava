package com.arquitecturajava.controlador.accion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.impl.LibroServiceImpl;

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroService libroService = new LibroServiceImpl();
		String isbn = request.getParameter("isbn");
		List<Categoria> listaDeCategorias = libroService.buscarCategoriasLibros();
		Libro libro = libroService.buscarLibroPorClave(isbn);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);
		return "FormularioEditarLibro.jsp";
	}

}
