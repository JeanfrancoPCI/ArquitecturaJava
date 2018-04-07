package com.arquitecturajava.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import com.arquitecturajava.JPAHelper;

@Entity 
@Table(name="Libros")
public class Libro {

	@Id
	private String isbn;
	private String titulo;
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	public Libro() {
	}

	public Libro(String isbn) {
		this.isbn = isbn;
	}

	public Libro(String isbn, String titulo, Categoria categoria) {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public int hashCode() {
		return isbn.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		String isbnLibro = ((Libro) o).getIsbn();
		return isbnLibro.equals(isbn);
	}
}
