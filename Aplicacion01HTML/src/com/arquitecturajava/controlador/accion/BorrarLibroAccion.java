package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.impl.LibroServiceImpl;

public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroService libroService = new LibroServiceImpl();
		String isbn = request.getParameter("isbn");
		Libro libro = libroService.buscarLibroPorClave(isbn);
		libroService.borrarLibro(libro);
		return "MostrarLibros.do";
	}
}
