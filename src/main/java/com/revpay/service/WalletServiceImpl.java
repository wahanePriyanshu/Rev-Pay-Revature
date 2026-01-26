package com.revpay.service;

import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	@Override
	public boolean sendMoney(long senderId, long receiverId, BigDecimal amount) {
		
		if(amount.compareTo(BigDecimal.ZERO ) <=0) {
			return false;
		}
		boolean deducted = walletDao.deductMoney(senderId, amount);
		
		if(!deducted) {
//			logger.warn("Deduction failed for senderId={}", senderId);
		
			return false;
		}
		
		boolean credited = walletDao.creditMoney(receiverId, amount);
		
		if(!credited) {
			walletDao.creditMoney(senderId, amount);
//			logger.error("Credit failed for receiverId={}, rollback done", receiverId);
			return false;
		}
		
		return true;
	}

}
