package net.riverSoft.DAO.impl;

import net.riverSoft.model.Credit;
import net.riverSoft.exception.DaoException;
import net.riverSoft.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("creditDAO")
public class CreditDaoImpl extends GenericDAOImpl<Credit, Integer> {

	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public Credit findByID(Integer id) throws DaoException {
		return hibernateUtil.fetchById(id, Credit.class);
	}

}
