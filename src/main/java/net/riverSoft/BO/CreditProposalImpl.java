package net.riverSoft.BO;

import net.riverSoft.model.Credit;

import java.math.BigDecimal;
import java.util.List;

/**
 * Реализация кредитного предложения.
 */
public class CreditProposalImpl implements CreditProposal {

	private final BigDecimal creditAmount; // размер кредита
	private final BigDecimal effectiveRate; // эффективная процентная ставка
	private final BigDecimal totalPayment; // полная стоимость кредита
	private final List<CreditPayment> payments; // список платежей
	private final BigDecimal initCredComm; // первоначальная комиссия
	private final BigDecimal totalCredComm; // итоговая комиссия

	/**
	 * Конструктор кредитного предложения.
	 *
	 * @param creditOrder
	 *            заявка на кредит
	 * @param creditOffer
	 *            оффер на кредит
	 */
	public CreditProposalImpl(final Credit creditOrder,
			final CreditOffer creditOffer) {

		// 1. Проверка заполненности свойств заявки на кредит
		checkCreditApplication(creditOrder);

		// 2. Заполняем свойства предложения
		this.creditAmount = creditOrder.getAmount();
		this.initCredComm = FinUtil.calcInitialCommission(
				creditOrder.getAmount(), creditOffer);

		BigDecimal monthlyCommission = FinUtil.calcMonthlyCommission(
				creditOrder.getAmount(), creditOffer);
		this.totalCredComm = this.initCredComm.add(monthlyCommission
				.multiply(new BigDecimal(creditOrder.getDurationInMonths())));
		switch (creditOrder.getPaymentType()) {
		case ANNUITY: {
			this.payments = FinUtil.calcAnnuityPayments(
					creditOrder.getAmount(), creditOrder.getDurationInMonths(),
					creditOrder.getStartDate(), creditOffer.getRate(),
					monthlyCommission);
			break;

		}
		case DIFFERENTIAL: {
			this.payments = FinUtil.calcDifferentialPayments(
					creditOrder.getAmount(), creditOrder.getDurationInMonths(),
					creditOrder.getStartDate(), creditOffer.getRate(),
					monthlyCommission);
			break;
		}
		default:
			throw new UnsupportedOperationException(
					creditOrder.getPaymentType() + " type is not supported");
		}

		this.totalPayment = FinUtil.calcTotalAmount(payments).add(
				this.initCredComm);
		this.effectiveRate = FinUtil.calcEffectiveRate(this);
	}

	@Override
	public List<CreditPayment> getPayments() {
		return payments;
	}

	@Override
	public BigDecimal getTotalPayment() {
		return totalPayment;
	}

	@Override
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	@Override
	public BigDecimal getEffectiveRate() {
		return effectiveRate;
	}

	@Override
	public BigDecimal getInitialCommission() {
		return initCredComm;
	}

	public BigDecimal getTotalCreditCommission() {
		return totalCredComm;
	}

	/**
	 * Проверяет заполненность свойств заявки на кредит.
	 *
	 * @param creditOrder
	 *            заявка на кредит.
	 * @throws IllegalArgumentException
	 *             в случае, когда параметры не заполнены.
	 */
	private void checkCreditApplication(final Credit creditOrder) {
		if (creditOrder.getPaymentType() == null) {
			throw new IllegalArgumentException(
					"Credit creditOrder must have non-null paymentType param.");
		}
		if (creditOrder.getDurationInMonths() == null) {
			throw new IllegalArgumentException(
					"Credit creditOrder must have non-null duration in months param.");
		}
		if (creditOrder.getStartDate() == null) {
			throw new IllegalArgumentException(
					"Credit creditOrder must have non-null start date param.");
		}
	}
}
