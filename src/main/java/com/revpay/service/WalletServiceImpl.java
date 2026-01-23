package com.revpay.service;

import java.math.BigDecimal;

import com.revpay.dao.WalletDao;

public class WalletServiceImpl implements WalletService {


	private final WalletDao walletDao = new WalletDao();
	
	@Override
	public BigDecimal viewBalance(long userId) {
		return walletDao.getBalanceByUserId(userId);
	}

}
