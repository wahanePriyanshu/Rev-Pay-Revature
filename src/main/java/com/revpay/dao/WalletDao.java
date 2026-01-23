package com.revpay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revpay.model.Wallet;
import com.revpay.util.DBUtil;

public class WalletDao {

	public void createWallet(long userId) {
		
		String sql ="Insert into wallets (user_id,balance) VALUES (?,?)";
		
		try (Connection con =DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setLong(1, userId);
			ps.setBigDecimal(2,java.math.BigDecimal.ZERO);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Wallet getWalletByUserId(long userId) {
		
		
		String sql ="select * from wallet where user_id =?";
		
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps= con.prepareStatement(sql)){
			
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Wallet wallet = new Wallet();
				wallet.setWalletId(rs.getLong("Wallet_id"));
				wallet.setUserId(rs.getLong("user_id"));
				wallet.setBalanace(rs.getBigDecimal("balance"));
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return null;
		
	}
}
