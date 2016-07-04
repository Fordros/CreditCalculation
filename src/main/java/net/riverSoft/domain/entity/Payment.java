package net.riverSoft.domain.entity;

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

	private static final long serialVersionUID = 1110477664112656944L;
	private Integer id;
	private Integer amount;
	private Date datePayment;
	private Credit credit;

	public Payment() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	@JoinColumn(name = "CREDIT_ID", referencedColumnName = "ID")
	public Credit getAccount() {
		return credit;
	}

	public void setAccount(Credit credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Payment{" + "id='" + id + '\'' + ", amount='" + amount + '\''
				+ ", date='" + datePayment + '\'' + '}';
	}

}
