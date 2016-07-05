package net.riverSoft.DAO;

import java.util.List;

import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Contract;

public interface ContractDao {

	public void save(Contract contract) throws DaoException;

	public void merge(Contract contract) throws DaoException;

	public void delete(Contract contract) throws DaoException;

	public List<Contract> findAll(Class<Contract> clazz) throws DaoException;

	public Contract findByID(Integer id) throws DaoException;

}
