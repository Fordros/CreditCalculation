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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "contract")
public class Contract implements Serializable {

	private static final long serialVersionUID = -5049398316031152349L;
	private Integer id;
	private String contractNumber;
	private Date contractDate;
	private Set<Credit> credits = new HashSet<>();

	public Contract() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTRACT", nullable = false, insertable = true, updatable = true)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CONTRACT_DATE", unique = false, nullable = false)
	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contract")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<Credit> getCredits() {
		return credits;
	}

	public void setCredits(Set<Credit> credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Contract{" + "id='" + id + '\'' + "contractNumber='"
				+ contractNumber + '\'' + ", contractDate='" + contractDate
				+ '\'' + '}';
	}
}
