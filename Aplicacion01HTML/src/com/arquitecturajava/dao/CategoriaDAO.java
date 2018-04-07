package com.arquitecturajava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.arquitecturajava.JPAHelper;
import com.arquitecturajava.bo.Categoria;

public class CategoriaDAO {
	
	public List<Categoria> buscarTodos() {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		TypedQuery<Categoria> consulta = manager.createQuery("SELECT c FROM Categoria c", Categoria.class);
		List<Categoria> listaDeCategorias = consulta.getResultList(); 
		manager.close();
		return listaDeCategorias;
	}
	
	public Categoria obtenerPorId(String id) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager(); 
		TypedQuery<Categoria> consulta = manager.createQuery("SELECT c FROM Categoria c WHERE c.id = ?1", Categoria.class);
		consulta.setParameter(1, id); 
		Categoria categoria = consulta.getSingleResult(); 
		manager.close();
		return categoria;
	}
}
