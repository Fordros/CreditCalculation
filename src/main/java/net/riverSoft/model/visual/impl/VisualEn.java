package net.riverSoft.model.visual.impl;

import net.riverSoft.model.visual.Visual;

public class VisualEn implements Visual {

	@Override
	public void MessageWelcome() {
		System.out.println("Calculation credit limit");
	}

	@Override
	public void MessageContractNumber() {
		System.out.println("Enter the number of the contract");
	}

	@Override
	public void MessageCreditLimit() {
		System.out.println("Enter the desired amount of credit");
	}

	@Override
	public void MessageLimitTerminationDate() {
		System.out.println("Enter the desired loan term");
	}

	@Override
	public void ShowPaymentGrid() {
		System.out.println("Payment grid");
	}

}
