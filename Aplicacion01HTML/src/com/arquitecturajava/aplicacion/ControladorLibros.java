package com.arquitecturajava.aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.Libro;

public class ControladorLibros extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher despachador = null;
		List<Libro> listaDeLibros = Libro.buscarTodos();
		List<String> listaDeCategorias = Libro.buscarTodasLasCategorias(); 
		req.setAttribute("listaDeLibros", listaDeLibros); 
		req.setAttribute("listaDeCategorias", listaDeCategorias); 
		despachador = req.getRequestDispatcher("MostrarLibros.jsp"); 
		despachador.forward(req, resp);
	}
	
}
