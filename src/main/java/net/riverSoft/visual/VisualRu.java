package net.riverSoft.visual;

import java.util.List;

public class VisualRu implements Visual {

	public String MessageWelcome() {
		return "Программа расчета кредитной ставки \n";
	}

	public String MessageContractNumber() {
		return "Введите номер договора \n";
	}

	public String MessageCreditLimit() {
		return "Введите желаемую сумму кредитного лимита";
	}

	public String MessageLimitTerminationDate() {
		return "Введите желаемое количество месяцев для погашения кредитного лимита";
	}

	public List<String> ShowPaymentGrid() {
		return null;
	}

}
