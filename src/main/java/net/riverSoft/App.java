package net.riverSoft;

import java.math.BigDecimal;

import net.riverSoft.BO.Credit;
import net.riverSoft.BO.CreditImpl;
import net.riverSoft.BO.CreditOffer;
import net.riverSoft.BO.CreditOfferImpl;
import net.riverSoft.BO.CreditPaymentType;
import net.riverSoft.BO.CreditProposal;
import net.riverSoft.BO.CreditProposalImpl;

public class App {

	public static void main(String[] args) {

		// Scanner scanner = new Scanner(System.in);
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("spring/spring.xml");
		//
		// ContractService contractService = (ContractService)
		// context.getBean("contractService");
		// CreditService creditService = (CreditService)
		// context.getBean("creditService");
		//
		// Contract contract = new Contract();
		// System.out.println("Введите номер договора");
		// contract.setContractNumber(scanner.next());
		// contract.setContractDate(new Date());
		//
		// Credit credit = new Credit();
		// credit.setContract(contract);
		// System.out.println("Введите желаемую сумму кредита");
		// credit.setCreditLimit(scanner.nextInt());
		// credit.setDecreaseAmount(10);
		// credit.setPercentDebtDue(20);
		// credit.setPercentPastDue(60);
		// credit.setLimitDecreaseDate(new Date());
		// System.out.println("Введите количество месяцев использования кредита");
		// System.out.println(scanner.nextInt());
		// credit.setLimitTerminationDate(new Date());
		//
		// try {
		// contractService.save(contract);
		// creditService.save(credit);
		// } catch (ServiceException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// scanner.close();

		CreditOffer creditOffer = new CreditOfferImpl();
		Credit credit = new CreditImpl(
				BigDecimal.valueOf(10000)).setPaymentType(
				CreditPaymentType.ANNUITY).setDurationInMonths(12);
		creditOffer.calculateProposal(credit);
		CreditProposal creditProposal = new CreditProposalImpl(
				credit, creditOffer);

		System.out.println(creditProposal.getPayments());
	}

}
