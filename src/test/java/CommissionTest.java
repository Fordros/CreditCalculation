import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import net.riverSoft.BO.*;
import net.riverSoft.BO.PrintUtil;
import net.riverSoft.model.Credit;

import org.junit.Before;
import org.junit.Test;


public class CommissionTest {

	private Credit application;
	private CreditOffer offer;

	@Before

	public void setUp() {
		BigDecimal amount = new BigDecimal(100000)
				.setScale(Constants.OUTPUT_AMOUNT_SCALE);
		application = new Credit(amount);
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
		PrintUtil.printApplication(application);
		CreditProposal proposal = offer.calculateProposal(application);
		assertEquals(proposal.getEffectiveRate().setScale(4, BigDecimal.ROUND_HALF_UP), (new BigDecimal("0.5068")));

		PrintUtil.printProposal(proposal);
	}

	@Test
	public void differentialCommissionTest() {
		application.setPaymentType(CreditPaymentType.DIFFERENTIAL);
		CreditProposal proposal = offer.calculateProposal(application);
		assertEquals(proposal.getEffectiveRate().setScale(4, BigDecimal.ROUND_HALF_UP), new BigDecimal("0.5152"));
		PrintUtil.printProposal(proposal);
	}
}