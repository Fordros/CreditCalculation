package net.riverSoft.DAO.impl;

import net.riverSoft.DAO.ContractDao;
import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Contract;

import org.springframework.stereotype.Repository;

@Repository("contractDAO")
public class ContractDaoImpl extends GenericDAOImpl<Contract, Integer>
		implements ContractDao {

	public Contract findByContractNumber(String contractNumber) {
		Contract contract = null;
		String sql = "SELECT a FROM university_groups a WHERE a.group_number = "
				+ contractNumber;
		contract = (Contract) getSession().createSQLQuery(sql);
		return contract;
	}

	public Contract findByID(Integer id) throws DaoException {
		return getSession().get(Contract.class, id);
	}

}
