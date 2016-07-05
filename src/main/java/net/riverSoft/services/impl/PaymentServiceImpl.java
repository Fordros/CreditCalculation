package net.riverSoft.services.impl;

import java.util.List;

import net.riverSoft.DAO.PaymentDao;
import net.riverSoft.exception.DaoException;
import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Payment;
import net.riverSoft.services.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("paymentService")
@Transactional
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentDao paymentDaoImpl;

	public void save(Payment payment) throws ServiceException {
		try {
			paymentDaoImpl.save(payment);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to save new payment",
					e);
		}
	}

	public void merge(Payment payment) throws ServiceException {
		try {
			paymentDaoImpl.merge(payment);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to update payment", e);
		}
	}

	public void delete(Payment payment) throws ServiceException {
		try {
			paymentDaoImpl.delete(payment);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to delete payment", e);
		}
	}

	public List<Payment> findAll() throws ServiceException {
		try {
			return paymentDaoImpl.findAll(Payment.class);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find all payments", e);
		}
	}

	public Payment findByID(Integer id) throws ServiceException {
		try {
			return paymentDaoImpl.findByID(id);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find payment by id", e);
		}
	}
}
