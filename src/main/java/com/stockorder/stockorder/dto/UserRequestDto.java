package com.stockorder.stockorder.dto;

import java.io.Serializable;

public class UserRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	private String name;
	private String address;
	private String mail;
	private Long mobileNumber;

	public UserRequestDto() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UserRequestDto [userId=" + userId + ", name=" + name + ", address=" + address + ", mail=" + mail
				+ ", mobileNumber=" + mobileNumber + "]";
	}

}
