package com.revpay.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revpay.dao.TransactionDao;
import com.revpay.model.Transaction;

public class TransactionServiceImpl implements TransactionService{

	private static final Logger logger = LogManager.getLogger(TransactionServiceImpl.class);
	
	private final TransactionDao transactionDao = new TransactionDao();
	
	@Override
	public List<Transaction> getUserTransactions(long userId) {
		// TODO Auto-generated method stub
		
		logger.info("Fetching transaction history for userId ={}",userId);
		
		return transactionDao.getUserTransactions(userId);
	}
	

	
}
