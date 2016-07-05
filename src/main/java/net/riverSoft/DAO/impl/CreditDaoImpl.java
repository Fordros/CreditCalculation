package net.riverSoft.DAO.impl;

import net.riverSoft.DAO.CreditDao;
import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Credit;

import org.springframework.stereotype.Repository;

@Repository("creditDAO")
public class CreditDaoImpl extends GenericDAOImpl<Credit, Integer> implements
		CreditDao {

	@Override
	public Credit findByID(Integer id) throws DaoException {
		return getSession().get(Credit.class, id);
	}

}
