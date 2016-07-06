package net.riverSoft.visual;

import java.util.List;

public class VisualEn implements Visual {

	@Override
	public String MessageWelcome() {
		return "Calculation credit limit";
	}

	@Override
	public String MessageContractNumber() {
		return "Enter the number of the contract";
	}

	@Override
	public String MessageCreditLimit() {
		return "Enter the desired amount of credit";
	}

	@Override
	public String MessageLimitTerminationDate() {
		return "Enter the desired loan term";
	}

	@Override
	public List<String> ShowPaymentGrid() {
		return null;
	}

}
