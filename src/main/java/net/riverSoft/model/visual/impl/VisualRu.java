package net.riverSoft.model.visual.impl;

import net.riverSoft.model.visual.Visual;

public class VisualRu implements Visual {

	public void MessageContractNumber() {
		System.out.println("Введите номер договора");
	}

	public void MessageWelcome() {
		System.out.println("Программа расчета кредитной ставки");
	}

	public void MessageCreditLimit() {
		System.out.println("Введите желаемую сумму кредитного лимита");
	}

	public void MessageLimitTerminationDate() {
		System.out.println("Введите желаемый срок выплаты кредита в месяцах");
	}

	public void ShowPaymentGrid() {
		System.out.println("Дата платежа; Сумма платежа; В погашение кредита; В погашение %; Остаток по кредиту");
	}

}
