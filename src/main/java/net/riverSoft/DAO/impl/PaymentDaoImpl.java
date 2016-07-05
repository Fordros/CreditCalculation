package net.riverSoft.DAO.impl;

import net.riverSoft.DAO.PaymentDao;
import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Payment;

import org.springframework.stereotype.Repository;

@Repository("paymentDAO")
public class PaymentDaoImpl extends GenericDAOImpl<Payment, Integer> implements
		PaymentDao {

	@Override
	public Payment findByID(Integer id) throws DaoException {
		return getSession().get(Payment.class, id);
	}
}
