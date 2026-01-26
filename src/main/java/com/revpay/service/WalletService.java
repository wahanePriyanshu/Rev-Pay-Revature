package com.revpay.service;

import java.math.BigDecimal;

public interface WalletService {
	
	BigDecimal viewBalance(long userId);
	
	boolean addMoney (long userId ,BigDecimal amount);
	
	boolean sendMoney(long senderId , long receiverId,BigDecimal amount);

}
