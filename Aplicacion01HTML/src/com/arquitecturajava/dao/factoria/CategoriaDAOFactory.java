package com.arquitecturajava.dao.factoria;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.hibernate.CategoriaDAOHibernateImpl;
import com.arquitecturajava.dao.jpa.CategoriaDAOJPAImpl;

public class CategoriaDAOFactory {
	
	public static CategoriaDAO getInstance() {
		String tipo = "JPA";
		if (tipo.equals("Hibernate")) {
			return new CategoriaDAOHibernateImpl(); 
		} 
		else {
			return new CategoriaDAOJPAImpl();
		} 
	}
}
