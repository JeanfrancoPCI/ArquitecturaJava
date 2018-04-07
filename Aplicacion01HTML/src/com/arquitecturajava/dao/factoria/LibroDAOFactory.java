package com.arquitecturajava.dao.factoria;

import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.hibernate.LibroDAOHibernateImpl;
import com.arquitecturajava.dao.jpa.LibroDAOJPAImpl;

public class LibroDAOFactory {
	
	public static LibroDAO getInstance() {
		String tipo = "JPA";
		if (tipo.equals("Hibernate")) {
			return new LibroDAOHibernateImpl(); 
		} 
		else {
			return new LibroDAOJPAImpl();
		} 
	}
}
