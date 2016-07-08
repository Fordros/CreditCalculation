import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import net.riverSoft.model.Credit;
import net.riverSoft.BO.CreditOffer;
import net.riverSoft.BO.CreditOfferImpl;
import net.riverSoft.BO.CreditPaymentType;
import net.riverSoft.BO.CreditProposal;

import org.junit.Test;



public class ThreeYearEPR {

	@Test
	public void calcThreeYearEPR() {
		CreditOffer offer = new CreditOfferImpl()
				.setRate(new BigDecimal("0.155"))
				.setOnceCommissionPercent(new BigDecimal("0.015"))
				.setOnceCommissionAmount(new BigDecimal("3000"))
				.setMonthlyCommissionPercent(new BigDecimal("0.005"))
				.setMonthlyCommissionAmount(new BigDecimal("100"));

		Credit app = new Credit(new BigDecimal(
				"300000")).setPaymentType(CreditPaymentType.ANNUITY)
				.setDurationInMonths(36);

		CreditProposal proposal = offer.calculateProposal(app);
		assertEquals(proposal.getEffectiveRate().setScale(4, BigDecimal.ROUND_HALF_UP), new BigDecimal("0.3168"));
	}
}
