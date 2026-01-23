package com.revpay.service;

import java.math.BigDecimal;

import com.revpay.dao.WalletDao;

public class WalletServiceImpl implements WalletService {


	private final WalletDao walletDao = new WalletDao();
	
	@Override
	public BigDecimal viewBalance(long userId) {
		return walletDao.getBalanceByUserId(userId);
	}

	@Override
	public boolean addMoney(long userId, BigDecimal amount) {
		if(amount.compareTo(BigDecimal.ZERO) <=0) {
			return false;
		}
		return walletDao.addMoney(userId, amount);
	}

}
