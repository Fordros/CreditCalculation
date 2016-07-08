package net.riverSoft.services;

import java.util.List;

import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Credit;

public interface CreditService {

	public void save(Credit credit) throws ServiceException;

	public void merge(Credit credit) throws ServiceException;

	public void delete(Credit credit) throws ServiceException;

	public List<Credit> findAll() throws ServiceException;

	public Credit findByID(Integer id) throws ServiceException;

	public Credit findByContractNumber(String contractNumber) throws ServiceException;

}
