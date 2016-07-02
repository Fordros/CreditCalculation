package net.riverSoft.DAO;

import java.io.Serializable;
import java.util.List;

import net.riverSoft.exception.DaoException;

public interface GenericDao<T, ID extends Serializable> {

	public Integer save(T entity) throws DaoException;

	public T merge(T entity) throws DaoException;

	public void delete(T entity) throws DaoException;

	public List<?> findAll(Class<?> clazz) throws DaoException;

	public T findByID(Integer id) throws DaoException;

}
