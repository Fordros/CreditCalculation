package net.riverSoft.domain.service;

import java.util.List;

import net.riverSoft.DAO.impl.ContractDaoImpl;
import net.riverSoft.domain.entity.Contract;
import net.riverSoft.exception.DaoException;
import net.riverSoft.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ContractServiceImpl {

	@Autowired
	ContractDaoImpl contractDaoImpl;

	@Transactional
	public Integer save(Contract contract) throws ServiceException {
		return contractDaoImpl.save(contract);
	}

	@Transactional
	public Contract merge(Contract contract) throws ServiceException {
		return contractDaoImpl.merge(contract);
	}

	@Transactional
	public void delete(Contract contract) throws ServiceException {
		contractDaoImpl.delete(contract);
	}

	@Transactional
	public List<Contract> findAll() throws ServiceException {
		return contractDaoImpl.findAll(Contract.class);
	}

	@Transactional
	public Object findByID(Integer id) throws ServiceException {
		try {
			return contractDaoImpl.findByID(id);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find contract by id", e);
		}
	}

}
