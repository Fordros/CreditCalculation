package net.riverSoft;

import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Credit;
import net.riverSoft.model.Payment;
import net.riverSoft.services.CreditService;
import net.riverSoft.services.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Scanner;


public class AppPayment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new
                ClassPathXmlApplicationContext("spring/spring.xml");

        CreditService creditService = (CreditService) context.getBean("creditService");
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");

        Payment payment = new Payment();
        Credit credit   = new Credit();
        try {
            credit = creditService.findByContractNumber("Credit_1");
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        payment.setCredit(credit);
        payment.setDatePayment(new Date());
        payment.setAmount(100);

        System.out.println(payment);

        scanner.close();

    }
}
