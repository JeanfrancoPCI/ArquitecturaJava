package com.arquitecturajava.controlador.accion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.impl.LibroServiceImpl;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroService libroService = new LibroServiceImpl();
		List<Categoria> listaDeCategorias = libroService.buscarCategoriasLibros();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "FormularioInsertarLibro.jsp";
	}

}
