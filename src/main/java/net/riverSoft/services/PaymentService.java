package net.riverSoft.services;

import java.util.List;

import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Payment;

public interface PaymentService {

	public void save(Payment payment) throws ServiceException;

	public void merge(Payment payment) throws ServiceException;

	public void delete(Payment payment) throws ServiceException;

	public List<Payment> findAll() throws ServiceException;

	public Payment findByID(Integer id) throws ServiceException;

}
