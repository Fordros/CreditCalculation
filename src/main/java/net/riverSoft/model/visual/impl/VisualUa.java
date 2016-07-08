package net.riverSoft.model.visual.impl;

import net.riverSoft.model.visual.Visual;

public class VisualUa implements Visual {

	@Override
	public void MessageWelcome() {
		System.out.println("Программа розрахунку кредитної ставки");
	}

	@Override
	public void MessageContractNumber() {
		System.out.println("Введіть номер договору");
	}

	@Override
	public void MessageCreditLimit() {
		System.out.println("Введіть бажану суму кредитного ліміту");
	}

	@Override
	public void MessageLimitTerminationDate() {
		System.out.println("Введіть бажаний срок виплати кредиту в м!сяць");
	}

	@Override
	public void ShowPaymentGrid() {
		System.out.println("С!тка таблиц!");
	}

}
