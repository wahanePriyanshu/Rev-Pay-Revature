package com.revpay.service;

import com.revpay.dao.BusinessDao;
import com.revpay.model.BusinessDetails;

public class BusinessServiceImpl implements BusinessService{

	private final BusinessDao  businessDao = new BusinessDao();
	@Override
	public boolean registerBusiness(BusinessDetails details) {
		// TODO Auto-generated method stub
		return businessDao.saveBusinessDetails(details);
	}

}
