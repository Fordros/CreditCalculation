package net.riverSoft.DAO.impl;

import net.riverSoft.domain.entity.Payment;
import net.riverSoft.exception.DaoException;
import net.riverSoft.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;

public class PaymentDaoImpl extends GenericDAOImpl<Payment, Integer> {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public Payment findByID(Integer id) throws DaoException {
		return hibernateUtil.fetchById(id, Payment.class);
	}
}
