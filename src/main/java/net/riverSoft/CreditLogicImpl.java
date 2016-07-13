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
import net.riverSoft.services.PaymentService;
import org.springframework.context.ApplicationContext;

public class CreditLogicImpl implements CreditLogic {

    private Visual visual;
    private ApplicationContext context;
    private Credit credit = new Credit();
    private CreditOffer offer = new CreditOfferImpl().setRate(new BigDecimal("0.2500"));//Инициализация офера и установка процентной ставки
    private Scanner scanner = new Scanner(System.in); //Подключения сканера (input данных)
    private CreditService creditService;
    private PaymentService paymentService;


    public void setVisual(Visual visual) {
        this.visual = visual;
    }


    public void actionApp(ApplicationContext context){
        this.context = context;

        //Логика приложения
        visual.WelcomeMessage();
        visual.ActionMessage();
        //2. Выбор действия кредитного модуля (выдача нового кредита или погашения действующего)

        if(scanner.nextInt() == 1){
            visual.ContractNumberMessage();
            String contactNumber = scanner.next();
            visual.AmountLimitMessage();
            BigDecimal amount = scanner.nextBigDecimal();
            visual.LimitTerminationDateMessage();
            Integer durationInMonths = scanner.nextInt();
            addCredit(durationInMonths, amount, contactNumber);
        }else{
            visual.ContractNumberMessage();
            String contactNumber = scanner.next();
            getDebt(contactNumber);
        }

        scanner.close();
    }

    @Override
    public void addCredit(Integer durationInMonths, BigDecimal amountCredit, String contractNumber) {
        //2.1 Выдача нового кредита
        creditService = (CreditService) context.getBean("creditService");

        credit.setStartDate(new Date());
        credit.setAmount(amountCredit);
        credit.setDurationInMonths(durationInMonths);
        credit.setContractNumber(contractNumber);

        visual.creditRepaymentSchemeMessage();
        //Выбор схемы кредитования
        if (scanner.nextInt() == 1) {
            credit.setPaymentType(CreditPaymentType.ANNUITY);
        } else {
            credit.setPaymentType(CreditPaymentType.DIFFERENTIAL);
        }

        CreditProposal proposal = offer.calculateProposal(credit);
        PrintUtil.printProposal(proposal);
        //Сохранение кредита в БД
        try {
            creditService.save(credit);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDebt(String contractNumber) {
    //2.2 Погашение действующего кредита
        creditService = (CreditService) context.getBean("creditService");
        paymentService =  (PaymentService) context.getBean("paymentService");
        Payment payment = new Payment();
        try {
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
}
