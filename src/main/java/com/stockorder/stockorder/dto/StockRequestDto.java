package com.stockorder.stockorder.dto;

import java.io.Serializable;

public class StockRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long stockId;
	private String stockName;
	private Double stockPrice;
	private Long volume;

	public StockRequestDto() {
		super();
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

	@Override
	public String toString() {
		return "StockRequestDto [stockId=" + stockId + ", stockName=" + stockName + ", stockPrice=" + stockPrice
				+ ", volume=" + volume + "]";
	}

}
