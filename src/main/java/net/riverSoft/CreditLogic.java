package net.riverSoft;


import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public interface CreditLogic {

    public void addCredit(Integer durationInMonths, BigDecimal amountCredit, String contractNumber);

    public void getDebt(String contractNumber);

    public void actionApp(ApplicationContext context);
}
