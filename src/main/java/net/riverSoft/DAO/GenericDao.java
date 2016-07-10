package net.riverSoft.DAO;

import java.io.Serializable;
import java.util.List;

import net.riverSoft.exception.DaoException;

/**
 * Абстрактный слой работы с БД (CRUD операции)
 */

public interface GenericDao<T, ID extends Serializable> {
    /**
     * @param entity
     *              сохраняет сущность в БД.
     */
	public void save(T entity) throws DaoException;
    /**
     * @param entity
     *              обновляет запись в БД.
     */
	public void merge(T entity) throws DaoException;
    /**
     * @param entity
     *              удаляет сущность из БД.
     */
	public void delete(T entity) throws DaoException;
    /**
     * @param clazz
     *              сущность для поиска.
     *
     * @return
     *              список всех записей в БД.
     */
	public List<T> findAll(Class<T> clazz) throws DaoException;
    /**
     * @param id
     *              ID в БД соответствующий нужной записи.
     *
     * @return
     *              сущность по ID.
     */
	public T findByID(Integer id) throws DaoException;

}
