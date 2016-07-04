package net.riverSoft.services;

import java.util.List;

import net.riverSoft.DAO.impl.PaymentDaoImpl;
import net.riverSoft.model.Payment;
import net.riverSoft.exception.DaoException;
import net.riverSoft.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentDaoImpl paymentDaoImpl;

	@Transactional
	public Integer save(Payment payment) throws ServiceException {
		return paymentDaoImpl.save(payment);
	}

	@Transactional
	public Payment merge(Payment payment) throws ServiceException {
		return paymentDaoImpl.merge(payment);
	}

	@Transactional
	public void delete(Payment payment) throws ServiceException {
		paymentDaoImpl.delete(payment);
	}

	@Transactional
	public List<Payment> findAll() throws ServiceException {
		return paymentDaoImpl.findAll(Payment.class);
	}

	@Transactional
	public Payment findByID(Integer id) throws ServiceException {
		try {
			return paymentDaoImpl.findByID(id);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find payment by id", e);
		}
	}
}