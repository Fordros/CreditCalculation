package net.riverSoft.DAO.impl;

import net.riverSoft.DAO.CreditDao;
import net.riverSoft.exception.DaoException;
import net.riverSoft.model.Credit;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("creditDAO")
public class CreditDaoImpl extends GenericDAOImpl<Credit, Integer> implements
		CreditDao {

	@Override
	public Credit findByContractNumber(String contractNumber) {
		Credit credit = null;
        Criteria criteria = getSession().createCriteria(Credit.class);
        criteria.add(Restrictions.eq("contractNumber",contractNumber));
		return (Credit) criteria.uniqueResult();
	}

	@Override
	public Credit findByID(Integer id) throws DaoException {
		return getSession().get(Credit.class, id);
	}

}
