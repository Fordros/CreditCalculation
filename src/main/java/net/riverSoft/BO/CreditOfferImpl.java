package net.riverSoft.BO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Реализация кредитного оффера.
 */

public class CreditOfferImpl implements CreditOffer {

	private static final CreditPaymentType DEFAULT_PAYMENT_TYPE = CreditPaymentType.ANNUITY;

	private String name;
	private BigDecimal minAmount;
	private BigDecimal maxAmount;
	private BigDecimal rate;
	private String currencyName;
	private Integer minMonthDuration;
	private Integer maxMonthDuration;
	private BigDecimal onceCommissionAmount;
	private BigDecimal onceCommissionPercent;
	private BigDecimal monthlyCommissionAmount;
	private BigDecimal monthlyCommissionPercent;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getMinAmount() {
		return minAmount;
	}

	@Override
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	@Override
	public BigDecimal getRate() {
		return rate;
	}

	@Override
	public String getCurrency() {
		return currencyName;
	}

	@Override
	public Integer getMinMonthDuration() {
		return minMonthDuration;
	}

	@Override
	public Integer getMaxMonthDuration() {
		return maxMonthDuration;
	}

	@Override
	public BigDecimal getMonthlyCommissionPercent() {
		return monthlyCommissionPercent;
	}

	@Override
	public BigDecimal getOnceCommissionAmount() {
		return onceCommissionAmount;
	}

	@Override
	public BigDecimal getOnceCommissionPercent() {
		return onceCommissionPercent;
	}

	@Override
	public BigDecimal getMonthlyCommissionAmount() {
		return monthlyCommissionAmount;
	}

	@Override
	public CreditProposal calculateProposal(final Credit credit) {
		if (!applicationCorrespondsToOffer(credit))
			return null;
		configureApplicationBlankParams(credit);
		return new CreditProposalImpl(credit, this);
	}

	@Override
	public CreditOffer setRate(final BigDecimal rate) {
		this.rate = rate;
		return this;
	}

	@Override
	public CreditOffer setOnceCommissionAmount(
			final BigDecimal onceCommissionAmount) {
		this.onceCommissionAmount = onceCommissionAmount;
		return this;
	}

	@Override
	public CreditOffer setOnceCommissionPercent(
			final BigDecimal onceCommissionPercent) {
		this.onceCommissionPercent = onceCommissionPercent;
		return this;
	}

	@Override
	public CreditOffer setMonthlyCommissionAmount(
			final BigDecimal monthlyCommissionAmount) {
		this.monthlyCommissionAmount = monthlyCommissionAmount;
		return this;
	}

	@Override
	public CreditOffer setMonthlyCommissionPercent(
			final BigDecimal monthlyCommissPercent) {
		this.monthlyCommissionPercent = monthlyCommissPercent;
		return this;
	}

	/**
	 * Устанавливает тип оплаты, валюту и срок кредита до значений оффера
	 * если некоторые из них или все равны null.
	 *
	 * @param credit
	 *            incoming credit
	 */
	private void configureApplicationBlankParams(
			final Credit credit) {
		if (credit.getPaymentType() == null) {
			credit.setPaymentType(DEFAULT_PAYMENT_TYPE);
		}
		if (credit.getCurrency() == null) {
			credit.setCurrency(getCurrency());
		}
		if (credit.getDurationInMonths() == null) {
			credit.setDurationInMonths(getMaxMonthDuration());
		}
		if (credit.getStartDate() == null) {
			credit.setStartDate(new Date());
		}
	}

	/**
	 * Проверяет, является ли параметры приложения в рамках текущего оффера.
	 *
	 * @param credit
	 *            incoming credit
	 * @return true если кредит является правильным в контексте данного оффера.
	 */
	private boolean applicationCorrespondsToOffer(
			final Credit credit) {

		BigDecimal amount = credit.getAmount();
		if (!amountInBounds(amount))
			return false;

		Integer duration = credit.getDurationInMonths();
		if (duration != null && !durationInBounds(duration))
			return false;

		String currency = credit.getCurrency();
		if (currency != null && getCurrency() != null
				&& !currency.equals(getCurrency())) {
			return false;
		}

		return true;
	}

	private boolean amountInBounds(final BigDecimal amount) {
		boolean amountInBounds = true;
		if (getMaxAmount() != null) {
			amountInBounds = amount.compareTo(getMaxAmount()) <= 0;
		}
		if (getMinAmount() != null) {
			amountInBounds = amountInBounds
					&& amount.compareTo(getMinAmount()) >= 0;
		}
		return amountInBounds;
	}

	private boolean durationInBounds(final Integer duration) {
		boolean durInBounds = true;
		if (getMaxMonthDuration() != null) {
			durInBounds = duration <= getMaxMonthDuration();
		}
		if (getMinMonthDuration() != null) {
			durInBounds = durInBounds && duration >= getMinMonthDuration();
		}
		return durInBounds;
	}
}
