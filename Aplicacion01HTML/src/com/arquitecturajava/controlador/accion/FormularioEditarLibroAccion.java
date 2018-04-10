package com.arquitecturajava.controlador.accion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.servicios.LibroService;

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroService libroService = (LibroService) getBean("libroService");
		CategoriaDAO categoriaDAO = (CategoriaDAO) getBean("categoriaDAO"); 
		LibroDAO libroDAO = (LibroDAO) getBean("libroDAO"); 
		libroService.setLibroDAO(libroDAO); 
		libroService.setCategoriaDAO(categoriaDAO);
		String isbn = request.getParameter("isbn");
		List<Categoria> listaDeCategorias = libroService.buscarCategoriasLibros();
		Libro libro = libroService.buscarLibroPorClave(isbn);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);
		return "FormularioEditarLibro.jsp";
	}

}
