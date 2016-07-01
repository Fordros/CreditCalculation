package net.riverSoft;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String contractNumber;
	private Integer amount;
	private Integer minimalAmount;
	private Date datePayment;
	private Contract contract;

	public Payment() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAY_ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ACCOUNT_NUMBER")
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name = "AMOUNT")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PAYMENT")
	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACC_ID", referencedColumnName = "ACC_ID")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Payment{" + "acc='" + accountNumber + '\'' + ", amount='"
				+ amount + '\'' + ", date='" + datePayment + '\'' + '}';
	}

}
