package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.servicios.LibroService;

public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroService libroService = (LibroService) getBean("libroService"); 
		LibroDAO libroDAO = (LibroDAO) getBean("libroDAO"); 
		libroService.setLibroDAO(libroDAO); 
		String isbn = request.getParameter("isbn");
		Libro libro = libroService.buscarLibroPorClave(isbn);
		libroService.borrarLibro(libro);
		return "MostrarLibros.do";
	}
}
