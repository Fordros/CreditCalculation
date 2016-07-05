package net.riverSoft.DAO;

import java.util.List;

import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Payment;

public interface PaymentDao {

	public void save(Payment payment) throws DaoException;

	public void merge(Payment payment) throws DaoException;

	public void delete(Payment payment) throws DaoException;

	public List<Payment> findAll(Class<Payment> clazz) throws DaoException;

	public Payment findByID(Integer id) throws DaoException;

}
