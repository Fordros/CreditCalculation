import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import net.riverSoft.BO.Credit;
import net.riverSoft.BO.CreditPayment;
import net.riverSoft.BO.CreditProposal;


public class TestUtil {

	public static void printProposal(CreditProposal proposal) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		List<CreditPayment> payments = proposal.getPayments();
		System.out.println("Total: " + proposal.getTotalPayment());
		System.out.println("Initial commission: "
				+ proposal.getInitialCommission());
		System.out.println("Effective rate: " + proposal.getEffectiveRate().setScale(2, BigDecimal.ROUND_HALF_UP));

		for (CreditPayment payment : payments) {
			System.out.print(dateFormat.format(payment.getDate()) + "; ");
			System.out.print(payment.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP) + "; ");
			System.out.print(payment.getDebt().setScale(2, BigDecimal.ROUND_HALF_UP) + "; ");
			System.out.print(payment.getInterest().setScale(2, BigDecimal.ROUND_HALF_UP) + "; ");
			//System.out.print(payment.getCommission().setScale(2, BigDecimal.ROUND_HALF_UP) + "; ");
			System.out.print(payment.getTotalLeft().setScale(2, BigDecimal.ROUND_HALF_UP) + "; ");
			System.out.println();

		}
	}

	public static void printApplication(final Credit application) {
		System.out.println("Application: ");
		System.out.println("\tAmount: " + application.getAmount());
		System.out.println("\t" + application.getDurationInMonths());

	}
}
