package com.arquitecturajava.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO {
	
	@Override
	public List<Libro> buscarTodos() {
		TypedQuery<Libro> consulta = getManager().createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria",Libro.class);
		return consulta.getResultList();
	}
	
	public List<Libro> buscarPorCategoria (String categoria) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l FROM Libro l WHERE l.categoria.id = ?1", Libro.class);
		consulta.setParameter(1, categoria); 
		List<Libro> listaDeLibros = consulta.getResultList(); 
		manager.close();
		return listaDeLibros;
	}
}
