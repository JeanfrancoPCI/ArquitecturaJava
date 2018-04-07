package com.arquitecturajava.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;

public class LibroDAOHibernateImpl extends GenericDAOHibernateImpl<Libro, String> implements LibroDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> buscarTodos() {
		SessionFactory factoriaSesion = HibernateHelper.getSessionFactory();
		Session session = factoriaSesion.openSession();
		List<Libro> listaDeLibros = session.createQuery(" from Libro libro right join fetch libro.categoria").list();
		session.close();
		return listaDeLibros;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> buscarPorCategoria (String categoria) {
		SessionFactory factoriaSesion = HibernateHelper.getSessionFactory();
		Session session = factoriaSesion.openSession();
		Query<Libro> consulta = session.createQuery(" from Libro libro where libro.categoria.id=:categoria");
		consulta.setParameter("categoria", categoria);
		List<Libro> listaDeLibro = consulta.list();
		session.close();
		return listaDeLibro;
	}

}
