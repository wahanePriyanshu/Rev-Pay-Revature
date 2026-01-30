package com.revpay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.revpay.model.BusinessDetails;
import com.revpay.util.DBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BusinessDao {
	
	private static final Logger logger =
            LogManager.getLogger(BusinessDao.class);
	
	public boolean saveBusinessDetails(BusinessDetails bd) {
		
		String sql =
				"INSERT INTO business_details " +
			            "(user_id, business_name, business_type, tax_id, address) " +
			            "VALUES (?, ?, ?, ?, ?)";
		
		try(Connection con = DBUtil.getConnection();
				PreparedStatement  ps = con.prepareStatement(sql))
		{
			ps.setLong(1, bd.getUserId());
			ps.setString(2,bd.getBusinessName());
			ps.setString(3,bd.getBusinessType());
			ps.setString(4, bd.getTaxId());
			ps.setString(5, bd.getAddress());
			
			return ps.executeUpdate()==1;
		}catch(Exception e) {
		logger.error("Error saving business details",e);
		}
		
		
		
		return false;
	}

}

