package net.riverSoft.model.visual.impl;

import net.riverSoft.model.visual.Visual;
/**
 * Реализация английского языка
 */
public class VisualEn implements Visual {

	public void WelcomeMessage() {
		System.out.println("Calculation credit limit");
	}

	public void ContractNumberMessage() {
		System.out.println("Enter the number of the contract");
	}

	public void AmountLimitMessage() {
		System.out.println("Enter the desired amount of credit");
	}

	public void LimitTerminationDateMessage() {
		System.out.println("Enter the desired loan term");
	}

	public void ActionMessage() {
		System.out.println("Enter action number: \n1 - new credit; \n2 - credit redemption");
	}

	public void ShowPaymentGridMessage() {
		System.out.println("Payment grid");
	}

	public void creditRepaymentSchemeMessage() {
		System.out.println("Enter credit repayment scheme: \n1 - annuity; \n2 - differential");
	}

	public void amountPaymentMessage() {
		System.out.println("Enter the amount of payment");
	}

}
