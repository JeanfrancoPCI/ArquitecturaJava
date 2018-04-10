package com.arquitecturajava.controlador.accion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.servicios.LibroService;

public class InsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroService libroService = (LibroService) getBean("libroService");
		CategoriaDAO categoriaDAO = (CategoriaDAO) getBean("categoriaDAO"); 
		LibroDAO libroDAO = (LibroDAO) getBean("libroDAO"); 
		libroService.setLibroDAO(libroDAO); 
		libroService.setCategoriaDAO(categoriaDAO);
		
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria"); 
		Categoria categoria2 = libroService.buscarCategoriaPorClave(categoria);
		Libro libro = new Libro(isbn, titulo, categoria2); 
		libroService.insertarLibro(libro);
		return "MostrarLibros.do";
	}

}
