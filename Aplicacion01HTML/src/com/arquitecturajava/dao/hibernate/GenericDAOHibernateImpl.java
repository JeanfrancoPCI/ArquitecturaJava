package com.arquitecturajava.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arquitecturajava.dao.GenericDAO;

public class GenericDAOHibernateImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;
	
	@SuppressWarnings("unchecked") 
	public GenericDAOHibernateImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	    this.claseDePersistencia = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	public T buscarPorClave(Id id) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		T objeto = null;
		objeto = (T) session.get(claseDePersistencia, id);
		session.close();
		return objeto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> buscarTodos() {
		SessionFactory factoriaSesion = HibernateHelper.getSessionFactory();
		Session session = factoriaSesion.openSession();
		List<T> listaDeLibros = session.createQuery(" from " + claseDePersistencia.getSimpleName() + " o").list();
		session.close();
		return listaDeLibros;
	}

	@Override
	public void salvar(T objeto) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.update(objeto);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void borrar(T objeto) {
		SessionFactory factoriaSesion = HibernateHelper.getSessionFactory();
		Session session = factoriaSesion.openSession();
		session.beginTransaction();
		session.delete(objeto);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void insertar(T objeto) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(objeto);
		session.getTransaction().commit();
		session.close();
	}

}
