package com.stockorder.stockorder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long stockId;
	private String stockName;
	private Double stockPrice;
	private Long volume;

	public Stock() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

}
