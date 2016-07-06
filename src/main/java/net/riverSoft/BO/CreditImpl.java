package net.riverSoft.BO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Реализация заявки на кредит.
 */

public class CreditImpl implements Credit {

	private final BigDecimal amount; // размер кредита
	private String currency; // валюта кредита (ISO 4217)
	private CreditPaymentType paymentType; // тип платежа (аннуитет, дифф.)
	private Integer durationInMonths; // срок кредита в месяцах
	private Date startDate; // дата получения кредита

	public CreditImpl(final BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String getCurrency() {
		return currency;
	}

	@Override
	public Credit setCurrency(final String currency) {
		this.currency = currency;
		return this;
	}

	@Override
	public CreditPaymentType getPaymentType() {
		return paymentType;
	}

	@Override
	public Credit setPaymentType(CreditPaymentType paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	@Override
	public Integer getDurationInMonths() {
		return durationInMonths;
	}

	@Override
	public Credit setDurationInMonths(Integer durationInMonths) {
		this.durationInMonths = durationInMonths;
		return this;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	public Credit setStartDate(final Date startDate) {
		this.startDate = startDate;
		return this;
	}

}
