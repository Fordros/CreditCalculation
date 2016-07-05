package net.riverSoft.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "credit")
public class Credit implements Serializable {

	private static final long serialVersionUID = -2234292491687066195L;
	private Integer id;
	private Contract contract;
	private Integer creditLimit; // начальная сумма КЛ
	private Integer decreaseAmount; // сумма уменьшения кредитного лимита
	private Date limitTerminationDate; // дата окончания кредитного лимита
	private Date limitDecreaseDate; // дата уменьшения кредитного лимита
	private Integer percentDebtDue; // процентная ставка на срочную
									// задолженность (тело КЛ)
	private Integer percentPastDue; // процентная ставка на просроченную
									// задолженность (несанкционированный овер)
	private Set<Payment> payments = new HashSet<>();

	public Credit() {
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

	@Column(name = "CREDIT_LIMIT", unique = false, nullable = false, length = 13)
	public Integer getCreditLimit() {
		return creditLimit;
	}

	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "ID_CONTRACT", referencedColumnName = "id_contract")
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Column(name = "DATE_END", unique = false, nullable = false)
	public Date getLimitTerminationDate() {
		return limitTerminationDate;
	}

	public void setLimitTerminationDate(Date limitTerminationDate) {
		this.limitTerminationDate = limitTerminationDate;
	}

	@Column(name = "DATE_DECREASE", unique = false, nullable = false)
	public Date getLimitDecreaseDate() {
		return limitDecreaseDate;
	}

	public void setLimitDecreaseDate(Date limitDecreaseDate) {
		this.limitDecreaseDate = limitDecreaseDate;
	}

	@Column(name = "PERCENT_DEBIT_DUE", unique = false, nullable = false)
	public Integer getPercentDebtDue() {
		return percentDebtDue;
	}

	public void setPercentDebtDue(Integer percentDebtDue) {
		this.percentDebtDue = percentDebtDue;
	}

	@Column(name = "PERCENT_PAST_DUE", unique = false, nullable = false)
	public Integer getPercentPastDue() {
		return percentPastDue;
	}

	public void setPercentPastDue(Integer percentPastDue) {
		this.percentPastDue = percentPastDue;
	}

	@Column(name = "DECREASE_AMOUNT")
	public Integer getDecreaseAmount() {
		return decreaseAmount;
	}

	public void setDecreaseAmount(Integer limitDecrease) {
		this.decreaseAmount = limitDecrease;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "credit")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Credit{" + "id='" + id + '\'' + ", credit limit='"
				+ creditLimit + '\'' + ", date end='" + limitTerminationDate
				+ '\'' + ", date decrease='" + limitDecreaseDate + '\''
				+ ", % limit='" + percentDebtDue + '\'' + ", % overdraft='"
				+ percentPastDue + '\'' + '}';
	}
}
