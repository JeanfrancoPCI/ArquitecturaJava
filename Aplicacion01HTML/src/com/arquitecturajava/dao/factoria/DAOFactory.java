package com.arquitecturajava.dao.factoria;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;

public interface DAOFactory {

	public CategoriaDAO getCategoriaDAO(); 
	public LibroDAO getLibroDAO();
}
