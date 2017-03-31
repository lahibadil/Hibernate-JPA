package com.lahib.data.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("STOCK")
public class Stock extends Investment {
	
	@Column(name = "SHARE_PRICE")
	private BigDecimal sharePrice;

	@Column(name = "QUANTITY")
	private BigDecimal quantity;

	public BigDecimal getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(BigDecimal sharePrice) {
		this.sharePrice = sharePrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}

