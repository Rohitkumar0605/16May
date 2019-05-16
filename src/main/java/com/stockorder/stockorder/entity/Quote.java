package com.stockorder.stockorder.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Quote implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quoteId;

	private Long stockId;
	private String stockName;
	private Long volume;
	private Double price;
	private Double purchasePrice;
	private Double fee;
	private Double totalFee;
	private String warning;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date time;
	private Long UserId;

	public Quote() {
		super();
	}

	public Long getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Long quoteId) {
		this.quoteId = quoteId;
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

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", stockId=" + stockId + ", stockName=" + stockName + ", volume=" + volume
				+ ", price=" + price + ", purchasePrice=" + purchasePrice + ", fee=" + fee + ", totalFee=" + totalFee
				+ ", warning=" + warning + ", time=" + time + ", UserId=" + UserId + "]";
	}

}
