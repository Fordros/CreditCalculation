package net.riverSoft.DAO.impl;

import net.riverSoft.model.Payment;
import net.riverSoft.exception.DaoException;
import net.riverSoft.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("paymentDAO")
public class PaymentDaoImpl extends GenericDAOImpl<Payment, Integer> {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public Payment findByID(Integer id) throws DaoException {
		return hibernateUtil.fetchById(id, Payment.class);
	}
}
