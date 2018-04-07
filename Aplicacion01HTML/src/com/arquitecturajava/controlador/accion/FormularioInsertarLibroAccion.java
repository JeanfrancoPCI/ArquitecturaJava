package com.arquitecturajava.controlador.accion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.factoria.CategoriaDAOFactory;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		CategoriaDAO categoriaDAO = CategoriaDAOFactory.getInstance();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "FormularioInsertarLibro.jsp";
	}

}
