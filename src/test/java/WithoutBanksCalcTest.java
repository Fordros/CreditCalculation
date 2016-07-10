import java.math.BigDecimal;

import net.riverSoft.BO.*;
import net.riverSoft.BO.PrintUtil;
import net.riverSoft.model.Credit;

import org.junit.Test;


public class WithoutBanksCalcTest {

	@Test
	public void withoutBanksTest() {
		Credit credit = new Credit(new BigDecimal("1000"));
		credit.setDurationInMonths(10);
		credit.setPaymentType(CreditPaymentType.ANNUITY);

		CreditOffer offer = new CreditOfferImpl();
		offer.setRate(new BigDecimal("0.1"));

		CreditProposal proposal = offer.calculateProposal(credit);
		PrintUtil.printProposal(proposal);
	}
}
