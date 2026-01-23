package com.revpay.service;

import com.revpay.dao.UserDao;
import com.revpay.dao.WalletDao;

import com.revpay.model.User;
import com.revpay.security.PasswordUtil;

public class UserServiceImpl implements UserService{

	
	private final UserDao userDao = new UserDao();
	private final WalletDao walletDao = new WalletDao();
	
	@Override
	public boolean registerUser(User user) {

	    user.setPasswordHash(
	        PasswordUtil.hashPassword(user.getPasswordHash())
	    );

	    long userId = userDao.saveUser(user);

	    if (userId > 0) {
	        walletDao.createWallet(userId);
	        return true;
	    }

	    return false;
	}
	
	@Override
	public User login(String emailorPhone,String password) {
		User user = userDao.findByEmailOrPhone(emailorPhone);
		
		if(user == null) {
			return null;
		}
		if (!PasswordUtil.verifyPassword(password, user.getPasswordHash())) {
		    return null;
		}
		
		
		
		if(user.isLocked()|| !user.isActive()) {
			return null;
		}
		return user;
		
	}

	
	
	
}
