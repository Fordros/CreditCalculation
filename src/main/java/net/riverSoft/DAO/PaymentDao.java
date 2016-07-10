package net.riverSoft.DAO;

import java.util.List;

import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Payment;

/**
 * CRUD операции для платежа
 */
public interface PaymentDao {
    /**
     * @param payment
     *              сохраняет платеж по кредиту в БД.
     */
	public void save(Payment payment) throws DaoException;
    /**
     * @param payment
     *              обновляет платеж по кредиту в БД.
     */
	public void merge(Payment payment) throws DaoException;
    /**
     * @param payment
     *              удаляет платеж по кредиту в БД.
     */
	public void delete(Payment payment) throws DaoException;
    /**
     * @param payment
     *              сущность платежа.
     * @return
     *              список всех платежей в БД.
     */
	public List<Payment> findAll(Class<Payment> payment) throws DaoException;
    /**
     * @param id
     *              строка платежа в БД.
     * @return
     *              платеж по ID в БД.
     */
	public Payment findByID(Integer id) throws DaoException;

}
