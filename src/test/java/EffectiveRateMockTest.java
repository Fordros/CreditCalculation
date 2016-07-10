import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import net.riverSoft.BO.*;

import net.riverSoft.BO.CalendarUtil;
import net.riverSoft.BO.FinUtil;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class EffectiveRateMockTest {

	@Test

	public void testCalcEffectiveScore() {
		CreditProposal proposal = mock(CreditProposal.class);
		when(proposal.getCreditAmount()).thenReturn(new BigDecimal(1000d));

		ArrayList<CreditPayment> payments = new ArrayList<CreditPayment>();
		Date date = new Date();
		payments.add(new CreditPaymentImpl(new BigDecimal(600d),
				date = CalendarUtil.nextMonthDate(date)));
		payments.add(new CreditPaymentImpl(new BigDecimal(0d),
				date = CalendarUtil.nextMonthDate(date)));
		payments.add(new CreditPaymentImpl(new BigDecimal(310d),
				date = CalendarUtil.nextMonthDate(date)));
		payments.add(new CreditPaymentImpl(new BigDecimal(194.25d),
				CalendarUtil.nextMonthDate(date)));
		when(proposal.getPayments()).thenReturn(payments);
		BigDecimal rate = FinUtil.calcEffectiveRate(proposal);
		System.out.println("Rate: " + rate);
	}
}