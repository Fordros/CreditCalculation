package net.riverSoft.services;

import java.util.List;

import net.riverSoft.DAO.impl.CreditDaoImpl;
import net.riverSoft.model.Credit;
import net.riverSoft.exception.DaoException;
import net.riverSoft.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("creditService")
public class CreditServiceImpl implements CreditService {
	@Autowired
	CreditDaoImpl creditDaoImpl;

	@Transactional
	public Integer save(Credit credit) throws ServiceException {
		return creditDaoImpl.save(credit);
	}

	@Transactional
	public Credit merge(Credit credit) throws ServiceException {
		return creditDaoImpl.merge(credit);
	}

	@Transactional
	public void delete(Credit credit) throws ServiceException {
		creditDaoImpl.delete(credit);
	}

	@Transactional
	public List<Credit> findAll() throws ServiceException {
		return creditDaoImpl.findAll(Credit.class);
	}

	@Transactional
	public Credit findByID(Integer id) throws ServiceException {
		try {
			return creditDaoImpl.findByID(id);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find credit by id", e);
		}
	}
}