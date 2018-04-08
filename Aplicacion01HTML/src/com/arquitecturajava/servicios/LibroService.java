package com.arquitecturajava.servicios;

import java.util.List;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;

public interface LibroService {
	
	public void insertarLibro(Libro libro);
	public void salvarLibro(Libro libro);
	public void borrarLibro(Libro libro);
	public List<Libro> buscarTodosLosLibros();
	public List<Categoria> buscarCategoriasLibros();
	public Libro buscarLibroPorClave(String isbn);
	public Categoria buscarCategoriaPorClave(String id);
	public List<Libro> buscarLibrosPorCategoria(String categoria);
}
