package com.arquitecturajava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.arquitecturajava.JPAHelper;
import com.arquitecturajava.bo.Libro;

public class LibroDAO {
	
	public void insertar(Libro libro) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		EntityTransaction tx = manager.getTransaction();
		tx.begin(); 
		manager.persist(libro);
		tx.commit();
	}
	
	public void salvar(Libro libro) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		EntityTransaction tx = manager.getTransaction();
		tx.begin(); 
		manager.merge(libro); 
		tx.commit(); 
		manager.close();
	}
	
	public void borrar(Libro libro) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		EntityTransaction tx = manager.getTransaction();
		tx.begin(); 
		manager.remove(manager.merge(libro)); 
		tx.commit();
		manager.close();
	}
	
	public List<Libro> buscarTodos() {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria", Libro.class);
		List<Libro> listaDeLibros = consulta.getResultList(); 
		manager.close();
		return listaDeLibros;
	}
	
	public Libro buscarPorClave(String isbn) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager(); 
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria where l.isbn = ?1", Libro.class);
		consulta.setParameter(1, isbn); 
		Libro libro = consulta.getSingleResult(); 
		manager.close();
		return libro;
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
