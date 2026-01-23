package com.revpay.model;

import java.math.BigDecimal;

public class Wallet {

	private long WalletId;
	private long userId;
	private BigDecimal  balanace;
	
	
	
	@Override
	public String toString() {
		return "Wallet [WalletId=" + WalletId + ", userId=" + userId + ", balanace=" + balanace + "]";
	}

	public Wallet() {
		
	}

	public Wallet(long userId) {
		
		
		this.userId = userId;
		this.balanace = BigDecimal.ZERO;
	}

	public long getWalletId() {
		return WalletId;
	}

	public void setWalletId(long walletId) {
		WalletId = walletId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public BigDecimal getBalanace() {
		return balanace;
	}

	public void setBalanace(BigDecimal balanace) {
		this.balanace = balanace;
	}
	
	
	
}
