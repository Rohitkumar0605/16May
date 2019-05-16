package com.stockorder.stockorder.dto;

import java.io.Serializable;
import java.util.Date;

public class GetQuoteResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String stockId;
	private String stockName;
	private Long volume;
	private Double price;
	private Double purchasePrice;
	private Double fee;
	private Double totalFee;
	private String warning;
	private Date time;

	public GetQuoteResponseDto() {
		super();
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "GetQuoteResponseDto [stockId=" + stockId + ", stockName=" + stockName + ", volume=" + volume
				+ ", price=" + price + ", purchasePrice=" + purchasePrice + ", fee=" + fee + ", totalFee=" + totalFee
				+ ", warning=" + warning + ", time=" + time + "]";
	}

}
