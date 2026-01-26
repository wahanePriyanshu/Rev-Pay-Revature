package com.revpay.service;

import com.revpay.model.User;

public interface UserService {

	boolean registerUser(User user);
	
	User login(String emailorPhone , String password);
	
	boolean verifyTransactionPin(long userId,String pin);
}
