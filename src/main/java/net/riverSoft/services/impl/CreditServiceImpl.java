package net.riverSoft.services.impl;

import java.util.List;

import net.riverSoft.DAO.CreditDao;
import net.riverSoft.exception.DaoException;
import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Credit;
import net.riverSoft.services.CreditService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("creditService")
@Transactional
public class CreditServiceImpl implements CreditService {
	@Autowired
	CreditDao creditDaoImpl;

	public void save(Credit credit) throws ServiceException {
		try {
			creditDaoImpl.save(credit);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to save new credit",
					e);
		}
	}

	public void merge(Credit credit) throws ServiceException {
		try {
			creditDaoImpl.merge(credit);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to update credit", e);
		}
	}

	public void delete(Credit credit) throws ServiceException {
		try {
			creditDaoImpl.delete(credit);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to delete credit", e);
		}
	}

	public List<Credit> findAll() throws ServiceException {
		try {
			return creditDaoImpl.findAll(Credit.class);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to find all credits",
					e);
		}
	}

	public Credit findByID(Integer id) throws ServiceException {
		try {
			return creditDaoImpl.findByID(id);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find credit by id", e);
		}
	}

	public Credit findByContractNumber(String contractNumber) throws ServiceException{
		try {
            return creditDaoImpl.findByContractNumber(contractNumber);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find credit by contract number", e);
		}
	}
}
