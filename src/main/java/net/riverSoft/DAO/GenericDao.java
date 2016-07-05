package net.riverSoft.DAO;

import java.io.Serializable;
import java.util.List;

import net.riverSoft.exception.DaoException;

public interface GenericDao<T, ID extends Serializable> {

	public void save(T entity) throws DaoException;

	public void merge(T entity) throws DaoException;

	public void delete(T entity) throws DaoException;

	public List<T> findAll(Class<T> clazz) throws DaoException;

	public T findByID(Integer id) throws DaoException;

}
