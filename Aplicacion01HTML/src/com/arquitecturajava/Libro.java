package com.arquitecturajava;

import java.util.List;

public class Libro {

	private String isbn;
	private String titulo;
	private String categoria;
	
	public Libro() {
	}

	public Libro(String isbn) {
		this.isbn = isbn;
	}

	public Libro(String isbn, String titulo, String categoria) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public static List<String> buscarTodasLasCategorias() {
		String consultaSQL = "select distinct(categoria) from Libros";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> listaDeCategorias = helper.seleccionarRegistros(consultaSQL, String.class);
		return listaDeCategorias;
	}

	public void insertar() {
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);
	}

	public static List<Libro> buscarTodos() {
		String consultaSQL = "select isbn,titulo,categoria from Libros"; 
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
		return listaDeLibros;
	}
	
	public void borrar() {
		String consultaSQL = "delete from Libros where isbn='" + this.isbn + "'";
		DataBaseHelper<Libro> helper =  new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);
	}
	
	public static Libro buscarPorClave(String isbn) {
		String consultaSQL = "select isbn, titulo, categoria from Libros where isbn='" + isbn + "'";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
		return listaDeLibros.get(0);
	}
	
	public void salvar() {
		String consultaSQL = "update Libros set titulo='" + this.titulo + "', categoria='" + this.categoria + 
			"' where isbn='" + this.isbn + "'";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);
	}
	
	public static List<Libro> buscarPorCategoria (String categoria) {
		String consultaSQL = "select isbn, titulo, categoria from Libros where categoria='" + categoria + "'";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
		return listaDeLibros;
	}
}
