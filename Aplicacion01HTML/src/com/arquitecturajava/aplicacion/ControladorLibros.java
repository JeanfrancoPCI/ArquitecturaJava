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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher despachador = null;
		List<Libro> listaDeLibros = null;
		List<String> listaDeCategorias = null;
		
		if(request.getServletPath() != null) {
			switch (request.getServletPath()) {
				case "/MostrarLibros.do":
					listaDeCategorias = Libro.buscarTodasLasCategorias();
					
					if (request.getParameter("categoria") != null) {
						if(request.getParameter("categoria").equals("seleccionar"))
							listaDeLibros = Libro.buscarTodos();
						else 
							listaDeLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));
					}
					else {
						request.setAttribute("categoria", "seleccionar");
						listaDeLibros = Libro.buscarTodos();
					}
					
					request.setAttribute("listaDeLibros", listaDeLibros); 
					request.setAttribute("listaDeCategorias", listaDeCategorias); 
					despachador = request.getRequestDispatcher("MostrarLibros.jsp");
					despachador.forward(request, response);
					break;
				case "/FormularioInsertarLibro.do":
					listaDeCategorias = Libro.buscarTodasLasCategorias();
					request.setAttribute("listaDeCategorias", listaDeCategorias);
					despachador = request.getRequestDispatcher("FormularioInsertarLibro.jsp");
					despachador.forward(request, response);
					break;
				case "/InsertarLibro.do":
					String isbn = request.getParameter("isbn");
					String titulo = request.getParameter("titulo");
					String categoria = request.getParameter("categoria");
					Libro libro = new Libro(isbn, titulo, categoria);
					libro.insertar();
					despachador = request.getRequestDispatcher("MostrarLibros.do");
					despachador.forward(request, response);
					break;
			}
		}
	}
	
}
