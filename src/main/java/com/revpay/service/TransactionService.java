package com.revpay.service;

import java.util.List;

import com.revpay.model.Transaction;

public interface TransactionService {

	List<Transaction>getUserTransactions (long userId);
}
