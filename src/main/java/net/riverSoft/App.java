package net.riverSoft;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

import net.riverSoft.BO.*;
import net.riverSoft.BO.PrintUtil;
import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Credit;

import net.riverSoft.model.Payment;
import net.riverSoft.services.CreditService;
import net.riverSoft.model.visual.Visual;
import net.riverSoft.model.visual.VisualUtil;
import net.riverSoft.services.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
        //Подключения сканера (input данных)
		Scanner scanner = new Scanner(System.in);
        //Загрузка контекста
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
        //Инициализация слоя сервисов
        CreditService creditService = (CreditService) context.getBean("creditService");
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");
        //Инициализация офера и установка процентной ставки
        CreditOffer offer = new CreditOfferImpl();
        offer.setRate(new BigDecimal("0.2500"));
        //Инициализация сущности кредита (тут ибо нужен в двух ветвлениях)
        Credit credit = new Credit();
        //Логика приложения
        //1. Выбор языка отображения сообщений
        System.out.println("Для выбора языка введите номер:\n1 - En\n2 - Ru\n3 - Ua");
        Visual visual = VisualUtil.selectLang(scanner.nextInt());
        visual.WelcomeMessage();
        visual.ActionMessage();
        //2. Выбор действия кредитного модуля (выдача нового кредита или погашения действующего)
        if(scanner.nextInt() == 1){
        //2.1 Выдача нового кредита
            visual.creditRepaymentSchemeMessage();
            //Выбор схемы кредитования
            if(scanner.nextInt() == 1){
                credit.setPaymentType(CreditPaymentType.ANNUITY);
            }else{
                credit.setPaymentType(CreditPaymentType.DIFFERENTIAL);
            }
            visual.ContractNumberMessage();
            credit.setContractNumber(scanner.next());
            visual.AmountLimitMessage();
            credit.setAmount(scanner.nextBigDecimal());
            visual.LimitTerminationDateMessage();
            credit.setDurationInMonths(scanner.nextInt());
            credit.setStartDate(new Date());
            CreditProposal proposal = offer.calculateProposal(credit);
            visual.ShowPaymentGridMessage();
            PrintUtil.printProposal(proposal);
            //Сохранение кредита в БД
            try {
                creditService.save(credit);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }else {
        //2.2 Погашение действующего кредита
            Payment payment = new Payment();
            try {
                visual.ContractNumberMessage();
                String contractNumber = scanner.next();
                //Поиск кредита по номеру договора в БД.
                credit = creditService.findByContractNumber(contractNumber);
                if (credit == null) {
                    System.out.println("Sorry, but we can't find credit with contract number: " + contractNumber);
                } else {
                    CreditProposal proposal = offer.calculateProposal(credit);
                    PrintUtil.printMinPayment(proposal);
                    payment.setCredit(credit);
                    payment.setDatePayment(new Date());
                    visual.AmountLimitMessage();
                    payment.setAmount(scanner.nextInt());
                    //Сохранение платежа в БД
                    paymentService.save(payment);
                }
            }catch(ServiceException e){
                e.printStackTrace();
            }
        }
		 scanner.close();
	}

}
