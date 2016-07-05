package net.riverSoft.DAO.impl;

import java.io.Serializable;
import java.util.List;

import net.riverSoft.DAO.GenericDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void merge(T entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public T findById(Serializable id, Class<T> entityClass) {
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> entityClass) {
		return getSession().createQuery(" FROM " + entityClass.getName())
				.list();
	}
}
