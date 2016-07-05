package net.riverSoft.visual;

import java.util.List;

public interface Visual {

	public String MessageWelcome();

	public String MessageContractNumber();

	public String MessageCreditLimit();

	public String MessageLimitTerminationDate();

	public List<String> ShowPaymentGrid();

}
