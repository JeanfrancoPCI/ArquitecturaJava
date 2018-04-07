package com.arquitecturajava.dao.factoria;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.hibernate.CategoriaDAOHibernateImpl;
import com.arquitecturajava.dao.hibernate.LibroDAOHibernateImpl;

public class DAOHibernateFactory implements DAOFactory {
	
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOHibernateImpl();
	}
	
	public LibroDAO getLibroDAO() {
		return new LibroDAOHibernateImpl();
	}
}
