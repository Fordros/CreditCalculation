package net.riverSoft;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.riverSoft.exception.ServiceException;
import net.riverSoft.model.Contract;
import net.riverSoft.model.Credit;
import net.riverSoft.services.ContractService;
import net.riverSoft.services.CreditService;

public class App {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");

		ContractService contractService = (ContractService) context.getBean("contractService");
		CreditService creditService = (CreditService) context.getBean("creditService");

		Contract contract = new Contract();
		System.out.println("Введите номер договора");
		contract.setContractNumber(scanner.next());
		contract.setContractDate(new Date());

		Credit credit = new Credit();
		credit.setContract(contract);
		System.out.println("Введите желаемую сумму кредита");
		credit.setCreditLimit(scanner.nextInt());
		credit.setDecreaseAmount(10);
		credit.setPercentDebtDue(20);
		credit.setPercentPastDue(60);
		credit.setLimitDecreaseDate(new Date());
		System.out.println("Введите количество месяцев использования кредита");
		System.out.println(scanner.nextInt());
		credit.setLimitTerminationDate(new Date());

		try {
			contractService.save(contract);
			creditService.save(credit);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.close();

	}

}
