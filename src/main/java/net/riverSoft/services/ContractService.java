package net.riverSoft.services;

import java.util.List;

import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Contract;

public interface ContractService {

	public void save(Contract contract) throws ServiceException;

	public void merge(Contract contract) throws ServiceException;

	public void delete(Contract contract) throws ServiceException;

	public List<Contract> findAll() throws ServiceException;

	public Contract findByID(Integer id) throws ServiceException;

}
