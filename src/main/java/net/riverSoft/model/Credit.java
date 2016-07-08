package net.riverSoft.model;

import net.riverSoft.BO.*;
import net.riverSoft.model.Payment;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Реализация заявки на кредит.
 */

@Entity
@Table(name = "credit")
public class Credit {

	private Integer id;
    private String contractNumber;
	private BigDecimal amount; // размер кредита
	private String currency; // валюта кредита (ISO 4217)
	private CreditPaymentType paymentType; // тип платежа (аннуитет, дифф.)
	private Integer durationInMonths; // срок кредита в месяцах
	private Date startDate; // дата получения кредита
    private Set<Payment> payments = new HashSet<>();

    public Credit() {
    }

    public Credit(BigDecimal amount) {
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CREDIT", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "CONTRACT_NUMBER", unique = true, nullable = false, length = 50)
    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    @Column(name = "CREDIT_AMOUNT", unique = false, nullable = false, length = 13)
	public BigDecimal getAmount() {
		return amount;
	}

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "CURRENCY",  length = 10)
	public String getCurrency() {
		return currency;
	}

	public Credit setCurrency(final String currency) {
		this.currency = currency;
		return this;
	}

    @Column(name = "CREDIT_PAYMENT_TYPE",  length = 15)
	public CreditPaymentType getPaymentType() {
		return paymentType;
	}

	public Credit setPaymentType(CreditPaymentType paymentType) {
		this.paymentType = paymentType;
		return this;
	}

    @Column(name = "DURATION_MONTHS",  length = 5)
	public Integer getDurationInMonths() {
		return durationInMonths;
	}

	public Credit setDurationInMonths(Integer durationInMonths) {
		this.durationInMonths = durationInMonths;
		return this;
	}

    @Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public Credit setStartDate(final Date startDate) {
		this.startDate = startDate;
		return this;
	}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credit")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }


    @Override
    public String toString() {
        return "Credit{"
                + "id='" + id + '\''
                + ", credit limit='" + amount + '\''
                + ", currency='" + currency + '\''
                + ", start date='" + startDate + '\''
                + ", paymentType='" + paymentType + '\''
                + ", durationInMonths='" + durationInMonths + '\''
                + '}';
    }
}
