package net.riverSoft.model.visual.impl;

import net.riverSoft.model.visual.Visual;
/**
 * Реализация русского языка
 */
public class VisualRu implements Visual {

	public void ContractNumberMessage() {
		System.out.println("Введите номер договора");
	}

	public void WelcomeMessage() {
		System.out.println("Программа расчета кредитной ставки");
	}

	public void AmountLimitMessage() {
		System.out.println("Введите желаемую сумму кредитного лимита");
	}

	public void LimitTerminationDateMessage() {
		System.out.println("Введите желаемый срок выплаты кредита в месяцах");
	}

	public void ActionMessage() {
		System.out.println("Введите номер действия: \n1 - выдача нового кредита; \n2 - погашение кредита");
	}

	public void ShowPaymentGridMessage() {
		System.out.println("Дата платежа; Сумма платежа; В погашение кредита; В погашение %; Остаток по кредиту");
	}
	public void creditRepaymentSchemeMessage() {
		System.out.println("Введите номер схемы погашения: \n1 - ануитет; \n2 - проценты на остаток");
	}
    public void amountPaymentMessage() {
        System.out.println("Введите сумму платежа");
    }

}
