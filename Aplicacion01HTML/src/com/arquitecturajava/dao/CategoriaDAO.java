package com.arquitecturajava.dao;

import java.util.List;

import com.arquitecturajava.bo.Categoria;

public interface CategoriaDAO {
	
	public List<Categoria> buscarTodos();	
	public Categoria buscarPorClave(String id) ;
}
