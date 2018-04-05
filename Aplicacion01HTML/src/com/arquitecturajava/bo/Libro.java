package com.arquitecturajava.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.arquitecturajava.HibernateHelper;

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

	public void insertar() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
		session.close();
	}
	
	public void salvar() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.update(this);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void borrar(String isbn) {
		SessionFactory factoriaSesion = HibernateHelper.getSessionFactory();
		Session session = factoriaSesion.openSession();
		session.beginTransaction();
		Libro libro = session.get(Libro.class, isbn);
		session.delete(libro);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodos() {
		SessionFactory factoriaSesion = HibernateHelper.getSessionFactory();
		Session session = factoriaSesion.openSession();
		List<Libro> listaDeLibros = session.createQuery(" from Libro libro right join fetch libro.categoria").list();
		session.close();
		return listaDeLibros;
	}
	
	public static Libro buscarPorClave(String isbn) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro = session.get(Libro.class, isbn);
		session.close();
		return libro;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarPorCategoria (String categoria) {
		SessionFactory factoriaSesion = HibernateHelper.getSessionFactory();
		Session session = factoriaSesion.openSession();
		Query<Libro> consulta = session.createQuery(" from Libro libro where libro.categoria.id=:categoria");
		consulta.setParameter("categoria", categoria);
		List<Libro> listaDeLibro = consulta.list();
		session.close();
		return listaDeLibro;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodasLasCategorias() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		String consultaSQL = "select distinct libro.categoria from Libro libro";
		List<Libro> listaDeCategorias = session.createQuery(consultaSQL).list();
		session.close();
		return listaDeCategorias;
	}
}
