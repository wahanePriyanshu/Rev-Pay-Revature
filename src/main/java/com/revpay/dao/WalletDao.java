package com.revpay.dao;

import org.apache.logging.log4j.LogManager;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revpay.model.Wallet;
import com.revpay.util.DBUtil;


public class WalletDao {
	
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("WalletDao.class");

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
	
	
	public BigDecimal getBalanceByUserId(long userId){
		
		String sql ="select balance from wallets where user_id=?";
		
		try(Connection con =DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)){
		
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getBigDecimal("balance");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return java.math.BigDecimal.ZERO;
		
	}
	
	
	public boolean addMoney(long userId, BigDecimal amount) {
		
		String sql = "UPDATE wallets SET balance = balance + ? WHERE user_id = ?";
		
		try(Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setBigDecimal(1, amount);
			ps.setLong(2, userId);
			
			return ps.executeUpdate()==1;
			
		}catch(Exception e) {
			logger.error("Error while adding money for userId ={}",userId,e);
		}
		
		return false;
		
	}
	
	public boolean deductMoney(long userId,BigDecimal amout) {
		
		
		String sql = "UPDATE wallets SET balance = balance - ? " +
					    "WHERE user_id = ? AND balance >= ?";
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setBigDecimal(1, amout);
			ps.setLong(2, userId);
			ps.setBigDecimal(3, amout);
			
			return ps.executeUpdate()==1;
			
		}catch(Exception e) {
			
		logger.error("Error in deducting money from userId ={}",userId, e);	
		}
		
		return false;
		
	}
	
	public boolean creditMoney(long userId,BigDecimal amount) {
		
		String sql = "UPDATE wallets SET balance = balance + ? WHERE user_id = ?";
		
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setBigDecimal(1, amount);
			ps.setLong(2, userId);
			
			int rows =ps.executeUpdate();
			
			logger.info("Crediting money :, userId={} , Debited = {}",
					userId,amount,rows);
			
			return rows ==1;
			
		}catch(Exception e) {
			
			logger.error("Error in adding money  for userId ={}",userId,e);
		}
		
		return false;
	}
	
	
	
	
	
}
