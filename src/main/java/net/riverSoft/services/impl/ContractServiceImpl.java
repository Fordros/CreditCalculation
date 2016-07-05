package net.riverSoft.services.impl;

import java.util.List;

import net.riverSoft.DAO.ContractDao;
import net.riverSoft.exception.DaoException;
import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Contract;
import net.riverSoft.services.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contractService")
@Transactional
public class ContractServiceImpl implements ContractService {

	@Autowired
	ContractDao contractDaoImpl;

	public void save(Contract contract) throws ServiceException {
		try {
			contractDaoImpl.save(contract);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to save new contract", e);
		}
	}

	public void merge(Contract contract) throws ServiceException {
		try {
			contractDaoImpl.merge(contract);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to update contract",
					e);
		}
	}

	public void delete(Contract contract) throws ServiceException {
		try {
			contractDaoImpl.delete(contract);
		} catch (DaoException e) {
			throw new ServiceException("Error when trying to delete contract",
					e);
		}
	}

	public List<Contract> findAll() throws ServiceException {
		try {
			return contractDaoImpl.findAll(Contract.class);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find all contracts", e);
		}
	}

	public Contract findByID(Integer id) throws ServiceException {
		try {
			return (Contract) contractDaoImpl.findByID(id);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find contract by id", e);
		}
	}

}
