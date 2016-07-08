package net.riverSoft;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

import net.riverSoft.BO.*;
import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Credit;

import net.riverSoft.services.CreditService;
import net.riverSoft.model.visual.Visual;
import net.riverSoft.model.visual.VisualUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		 Scanner scanner = new Scanner(System.in);
		 ApplicationContext context = new
				 ClassPathXmlApplicationContext("spring/spring.xml");

		 CreditService creditService = (CreditService)
		 context.getBean("creditService");

        CreditOffer offer = new CreditOfferImpl();
        offer.setRate(new BigDecimal("0.2500"));

        Credit credit = new Credit();

        System.out.println("Для выбора языка введите номер (1 - En, 2 - Ru, 3 - Ua)");
        Visual visual = VisualUtil.selectLang(scanner.nextInt());
        visual.MessageWelcome();


        visual.MessageContractNumber();
        credit.setContractNumber(scanner.next());
        visual.MessageCreditLimit();
        credit.setAmount(scanner.nextBigDecimal());
        visual.MessageLimitTerminationDate();
        credit.setDurationInMonths(scanner.nextInt());
        credit.setStartDate(new Date());
        credit.setPaymentType(CreditPaymentType.DIFFERENTIAL);

        CreditProposal proposal = offer.calculateProposal(credit);
        visual.ShowPaymentGrid();
        PrintUtil.printProposal(proposal);

		 try {
		 creditService.save(credit);
		 } catch (ServiceException e) {
		    e.printStackTrace();
		 }

		 scanner.close();


	}

}
