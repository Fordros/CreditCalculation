package net.riverSoft.domain.service;


import net.riverSoft.DAO.impl.CreditDaoImpl;
import net.riverSoft.DAO.impl.PaymentDaoImpl;
import net.riverSoft.domain.entity.Credit;
import net.riverSoft.domain.entity.Payment;
import net.riverSoft.exception.DaoException;
import net.riverSoft.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class PaymentServiceImpl {
    @Autowired
    PaymentDaoImpl paymentDaoImpl;

    @Transactional
    public Integer save(Payment payment) throws ServiceException {
        return paymentDaoImpl.save(payment);
    }

    @Transactional
    public Payment merge(Payment payment) throws ServiceException {
        return paymentDaoImpl.merge(payment);
    }

    @Transactional
    public void delete(Payment payment) throws ServiceException {
        paymentDaoImpl.delete(payment);
    }

    @Transactional
    public List<Payment> findAll() throws ServiceException {
        return paymentDaoImpl.findAll(Payment.class);
    }

    @Transactional
    public Payment findByID(Integer id) throws ServiceException {
        try {
            return paymentDaoImpl.findByID(id);
        } catch (DaoException e) {
            throw new ServiceException(
                    "Error when trying to find payment by id", e);
        }
    }
}
