package net.riverSoft.DAO.impl;

import net.riverSoft.domain.entity.Contract;
import net.riverSoft.exception.DaoException;
import net.riverSoft.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("contractDAO")
public class ContractDaoImpl extends GenericDAOImpl<Contract, Integer> {

	@Autowired
	private HibernateUtil hibernateUtil;

	public Contract findByContractNumber(String contractNumber) {
		Contract contract = null;
		String sql = "SELECT a FROM university_groups a WHERE a.group_number = "
				+ contractNumber;
		contract = (Contract) hibernateUtil.fetchAll(sql);
		return contract;
	}

	public Contract findByID(Integer id) throws DaoException {
		return hibernateUtil.fetchById(id, Contract.class);
	}
}
