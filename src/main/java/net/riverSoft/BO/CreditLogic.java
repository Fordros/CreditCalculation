package net.riverSoft.BO;

import java.util.Date;

public interface CreditLogic {

	public void addContract(Date contractDate, Integer creditLimit, String contractNum);

	public void getContract(String contractNum);

}
