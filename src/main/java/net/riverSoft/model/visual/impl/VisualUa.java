package net.riverSoft.model.visual.impl;

import net.riverSoft.model.visual.Visual;
/**
 * Реализация украинского языка
 */
public class VisualUa implements Visual {

	public void WelcomeMessage() {
		System.out.println("Программа розрахунку кредитної ставки");
	}

	public void ContractNumberMessage() {
		System.out.println("Введіть номер договору");
	}

	public void AmountLimitMessage() {
		System.out.println("Введіть бажану суму кредитного ліміту");
	}

	public void LimitTerminationDateMessage() {
		System.out.println("Введіть бажаний срок виплати кредиту в місяцях");
	}

	public void ActionMessage() {
		System.out.println("Введіть номер дії: \n1 - видача нового редиту; \n2 - погашення кредиту");
	}

	public void ShowPaymentGridMessage() {
		System.out.println("Сітка таблиці");
	}

    public void creditRepaymentSchemeMessage() {
		System.out.println("Введіть номер схеми погашення кредиту: \n1 - ануітет; \n2 - відсотки на залишок");
	}

    public void amountPaymentMessage() {
        System.out.println("Введіть суму платежа");
    }

}
