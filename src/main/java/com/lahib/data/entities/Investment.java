package com.lahib.data.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="INVESTMENT_TYPE")
@Table(name="INVESTMENT")
public abstract class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INVESTMENT_ID")
	private Long investmentId;

	@JoinColumn(name="PORTFOLIO_ID")
	@ManyToOne(cascade=CascadeType.ALL)
	private Portfolio portfolio;
	
	@Column(name = "NAME")
	protected String name;

	@Column(name = "ISSUER")
	protected String issuer;

	@Column(name = "PURCHASE_DATE")
	protected Date purchaseDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(Long investmentId) {
		this.investmentId = investmentId;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	
	
}