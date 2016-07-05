package net.riverSoft.visual;

import java.util.List;

public class VisualRus implements Visual {

	@Override
	public String MessageWelcome() {
		return "Программа расчета кредитной ставки \n";
	}

	@Override
	public String MessageContractNumber() {
		return "Введите номер договора \n";
	}

	@Override
	public String MessageCreditLimit() {
		return "Введите желаемую сумму кредитного лимита";
	}

	@Override
	public String MessageLimitTerminationDate() {
		return "Введите количество месяцев желаемое для погашения кредитного лимита";
	}

	@Override
	public List<String> ShowPaymentGrid() {
		return null;
	}

}
