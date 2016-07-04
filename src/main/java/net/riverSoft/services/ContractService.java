package net.riverSoft.services;

import java.util.List;

import net.riverSoft.model.Contract;
import net.riverSoft.exception.ServiceException;

public interface ContractService {

	public Integer save(Contract contract) throws ServiceException;

	public Contract merge(Contract contract) throws ServiceException;

	public void delete(Contract contract) throws ServiceException;

	public List<Contract> findAll() throws ServiceException;

	public Contract findByID(Integer id) throws ServiceException;

}
