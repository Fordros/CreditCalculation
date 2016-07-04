package net.riverSoft;

import java.util.Date;

import net.riverSoft.domain.entity.Contract;
import net.riverSoft.exception.ServiceException;
import net.riverSoft.services.ContractService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("load context");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		Contract contract = new Contract();
		contract.setContractNumber("554466W");
		contract.setContractDate(new Date());
		ContractService contractService = (ContractService) context
				.getBean("contractService");
		try {
			contractService.save(contract);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		context.close();
	}

}
