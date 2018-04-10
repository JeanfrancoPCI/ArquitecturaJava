package com.arquitecturajava.servicios.impl;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.servicios.LibroService;

public class LibroServiceImpl implements LibroService {
	
	private LibroDAO libroDAO = null;
	private CategoriaDAO categoriaDAO = null;
	private ClassPathXmlApplicationContext factoria = null; 
	
	public LibroServiceImpl() {
		factoria = new ClassPathXmlApplicationContext("applicationContext.xml");
		libroDAO = (LibroDAO) factoria.getBean("libroDAO"); 
		categoriaDAO = (CategoriaDAO) factoria.getBean("categoriaDAO");
	}
	
	@Override
	public void insertarLibro(Libro libro) {
		libroDAO.insertar(libro);
	}

	@Override
	public void salvarLibro(Libro libro) {
		libroDAO.salvar(libro);
	}

	@Override
	public void borrarLibro(Libro libro) {
		libroDAO.borrar(libro);
	}

	@Override
	public List<Libro> buscarTodosLosLibros() {
		return libroDAO.buscarTodos();
	}

	@Override
	public List<Categoria> buscarCategoriasLibros() {
		return categoriaDAO.buscarTodos();
	}

	@Override
	public Libro buscarLibroPorClave(String isbn) {
		return libroDAO.buscarPorClave(isbn);
	}

	@Override
	public Categoria buscarCategoriaPorClave(String id) {
		return categoriaDAO.buscarPorClave(id);
	}

	@Override
	public List<Libro> buscarLibrosPorCategoria(String categoria) {
		return libroDAO.buscarPorCategoria(categoria);
	}
}
