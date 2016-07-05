package net.riverSoft.visual;

import java.util.List;

public class VisualUa implements Visual {

	@Override
	public String MessageWelcome() {
		return "Программа розрахунку кредитної ставки \n";
	}

	@Override
	public String MessageContractNumber() {
		return "Введіть номер договору \n";
	}

	@Override
	public String MessageCreditLimit() {
		return "Введіть бажану суму кредитного ліміту \n";
	}

	@Override
	public String MessageLimitTerminationDate() {
		return "Введіть бажану кількість місяців для погашення кредитного ліміту \n";
	}

	@Override
	public List<String> ShowPaymentGrid() {
		return null;
	}

}
