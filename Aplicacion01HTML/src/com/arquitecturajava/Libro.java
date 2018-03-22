package com.arquitecturajava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Libro {

	private String isbn;
	private String titulo;
	private String categoria;

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

	public Libro(String isbn, String titulo, String categoria) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	public static ArrayList<String> buscarTodasLasCategorias() {
		String consultaSQL = "select distinct(categoria) from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		ArrayList<String> listaDeCategorias = new ArrayList<String>(); 
		String categoria = null;
		
		try {
			while (rs.next()) {
				categoria = rs.getString("categoria"); 
				listaDeCategorias.add(categoria);
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return listaDeCategorias;
	}

	public void insertar() {
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";
		DataBaseHelper helper = new DataBaseHelper();
		helper.modificarRegistro(consultaSQL);
	}

	public static ArrayList<Libro> buscarTodos() {
		String consultaSQL = "select isbn,titulo,categoria from Libros"; 
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL); 
		ArrayList<Libro> listaDeLibros = new ArrayList<Libro>();
		
		try {
			while (rs.next()) {
				listaDeLibros.add(
					new Libro(rs.getString("isbn"), 
							rs.getString("titulo"), 
							rs.getString("categoria")));
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage()); 
		}
		
		return listaDeLibros;
	}
}
