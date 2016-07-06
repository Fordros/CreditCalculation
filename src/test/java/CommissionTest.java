import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import net.riverSoft.BO.Constants;
import net.riverSoft.BO.Credit;
import net.riverSoft.BO.CreditImpl;
import net.riverSoft.BO.CreditOffer;
import net.riverSoft.BO.CreditOfferImpl;
import net.riverSoft.BO.CreditPaymentType;
import net.riverSoft.BO.CreditProposal;

import org.junit.Before;
import org.junit.Test;


public class CommissionTest {

	private Credit application;
	private CreditOffer offer;

	@Before

	public void setUp() {
		BigDecimal amount = new BigDecimal(100000)
				.setScale(Constants.OUTPUT_AMOUNT_SCALE);
		application = new CreditImpl(amount);
		application.setDurationInMonths(12);

		offer = new CreditOfferImpl();
		offer.setRate(new BigDecimal("0.1699")
				.setScale(Constants.OUTPUT_PERCENT_SCALE));
		offer.setOnceCommissionAmount(new BigDecimal("100")
				.setScale(Constants.OUTPUT_AMOUNT_SCALE));
		offer.setOnceCommissionPercent(new BigDecimal("0.01")
				.setScale(Constants.OUTPUT_PERCENT_SCALE));
		offer.setMonthlyCommissionAmount(new BigDecimal("100")
				.setScale(Constants.OUTPUT_AMOUNT_SCALE));
		offer.setMonthlyCommissionPercent(new BigDecimal("0.01")
				.setScale(Constants.OUTPUT_PERCENT_SCALE));
	}

	@Test
	public void annuityCommissionTest() {
		application.setPaymentType(CreditPaymentType.ANNUITY);
		TestUtil.printApplication(application);
		CreditProposal proposal = offer.calculateProposal(application);
		assertEquals(proposal.getEffectiveRate().setScale(4, BigDecimal.ROUND_HALF_UP), (new BigDecimal("0.5068")));

		TestUtil.printProposal(proposal);
	}

	@Test
	public void differentialCommissionTest() {
		application.setPaymentType(CreditPaymentType.DIFFERENTIAL);
		CreditProposal proposal = offer.calculateProposal(application);
		assertEquals(proposal.getEffectiveRate().setScale(4, BigDecimal.ROUND_HALF_UP), new BigDecimal("0.5152"));
		TestUtil.printProposal(proposal);
	}
}