package net.riverSoft.DAO.impl;

import java.io.Serializable;
import java.util.List;

import net.riverSoft.DAO.GenericDao;
import net.riverSoft.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDao<T, ID> {

	@Autowired
	private HibernateUtil hibernateUtil;

	public Integer save(T entity) {
		return (Integer) hibernateUtil.create(entity);
	}

	public T merge(T entity) {
		return hibernateUtil.update(entity);
	}

	public void delete(T entity) {
		hibernateUtil.delete(entity);
	}

	public T findByID(Class clazz, Integer id) {
		return (T) hibernateUtil.fetchById(id, clazz);
	}

	public List<T> findAll(Class clazz) {
		return hibernateUtil.fetchAll(clazz);
	}
}
