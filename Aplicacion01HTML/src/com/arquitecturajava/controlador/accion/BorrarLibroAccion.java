package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;

public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroDAO libroDAO = new LibroDAO();
		String isbn = request.getParameter("isbn");
		Libro libro = libroDAO.buscarPorClave(isbn);
		libroDAO.borrar(libro);
		return "MostrarLibros.do";
	}
}
