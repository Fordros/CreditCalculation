package net.riverSoft.DAO;

import java.util.List;

import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Credit;

public interface CreditDao {

	public void save(Credit credit) throws DaoException;

	public void merge(Credit credit) throws DaoException;

	public void delete(Credit credit) throws DaoException;

	public List<Credit> findAll(Class<Credit> clazz) throws DaoException;

	public Credit findByID(Integer id) throws DaoException;

	public Credit findByContractNumber(String contractNumber) throws DaoException;

}
