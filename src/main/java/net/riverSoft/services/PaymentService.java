package net.riverSoft.services;

import java.util.List;

import net.riverSoft.domain.entity.Payment;
import net.riverSoft.exception.ServiceException;

public interface PaymentService {

	public Integer save(Payment payment) throws ServiceException;

	public Payment merge(Payment payment) throws ServiceException;

	public void delete(Payment payment) throws ServiceException;

	public List<Payment> findAll() throws ServiceException;

	public Payment findByID(Integer id) throws ServiceException;

}
