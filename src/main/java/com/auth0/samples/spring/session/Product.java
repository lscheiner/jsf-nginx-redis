package com.auth0.samples.spring.session;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
    private BigDecimal price;

    public Product(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
