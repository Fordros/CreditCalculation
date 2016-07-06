import java.math.BigDecimal;

import net.riverSoft.BO.Credit;
import net.riverSoft.BO.CreditImpl;
import net.riverSoft.BO.CreditOffer;
import net.riverSoft.BO.CreditOfferImpl;
import net.riverSoft.BO.CreditPaymentType;
import net.riverSoft.BO.CreditProposal;

import org.junit.Test;


public class WithoutBanksCalcTest {

	@Test
	public void withoutBanksTest() {
		Credit credit = new CreditImpl(new BigDecimal("1000"));
		credit.setDurationInMonths(12);
		credit.setPaymentType(CreditPaymentType.DIFFERENTIAL);

		CreditOffer offer = new CreditOfferImpl();
		offer.setRate(new BigDecimal("0.1"));

		CreditProposal proposal = offer.calculateProposal(credit);
		TestUtil.printProposal(proposal);
	}
}
