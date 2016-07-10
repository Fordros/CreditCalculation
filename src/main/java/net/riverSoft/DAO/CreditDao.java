package net.riverSoft.DAO;

import java.util.List;

import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Credit;

/**
 * CRUD операции для кредита
 */

public interface CreditDao {
    /**
     * @param credit
     *              сохраняет кредит в БД.
     */
	public void save(Credit credit) throws DaoException;
    /**
     * @param credit
     *              обновляет существующий кредит в БД.
     */
	public void merge(Credit credit) throws DaoException;
    /**
     * @param credit
     *              удаляет запись о кредите в БД.
     */
	public void delete(Credit credit) throws DaoException;
    /**
     * @param credit
     *              сущность кредита.
     * @return
     *              список всех кредитов в БД.
     */
	public List<Credit> findAll(Class<Credit> credit) throws DaoException;
    /**
     * @param id
     *              строка кредита в БД.
     * @return
     *              кредит по ID в БД.
     */
	public Credit findByID(Integer id) throws DaoException;
    /**
     * @param contractNumber
     *              кредитный номер договора.
     * @return
     *              кредит с нужным номером договора.
     */
	public Credit findByContractNumber(String contractNumber) throws DaoException;

}
