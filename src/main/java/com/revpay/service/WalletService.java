package com.revpay.service;

import java.math.BigDecimal;

public interface WalletService {
	
	BigDecimal viewBalance(long userId);

}
