package net.riverSoft.services;

import java.util.List;

import net.riverSoft.DAO.impl.ContractDaoImpl;
import net.riverSoft.model.Contract;
import net.riverSoft.exception.DaoException;
import net.riverSoft.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contractService")
public class ContractServiceImpl implements ContractService {

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
	public Contract findByID(Integer id) throws ServiceException {
		try {
			return (Contract) contractDaoImpl.findByID(id);
		} catch (DaoException e) {
			throw new ServiceException(
					"Error when trying to find contract by id", e);
		}
	}

}
