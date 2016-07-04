package net.riverSoft.services;

import java.util.List;

import net.riverSoft.model.Credit;
import net.riverSoft.exception.ServiceException;

public interface CreditService {

	public Integer save(Credit credit) throws ServiceException;

	public Credit merge(Credit credit) throws ServiceException;

	public void delete(Credit credit) throws ServiceException;

	public List<Credit> findAll() throws ServiceException;

	public Credit findByID(Integer id) throws ServiceException;

}
