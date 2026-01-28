package com.revpay.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.revpay.model.Transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revpay.util.DBUtil;

public class TransactionDao {

	private static final Logger logger =
            LogManager.getLogger(TransactionDao.class);
	
	public void saveSendTransaction( long fromUserId,
			long toUserId,
			BigDecimal amount,
			String status,
			String note) {
		
		String sql="INSERT INTO transactions " +
	            "(from_user_id, to_user_id, amount, transaction_type, status, note) " +
	            "VALUES (?, ?, ?, 'SEND', ?, ?)";
		
		try(Connection con =DBUtil.getConnection();
				PreparedStatement ps= con.prepareStatement(sql)){
			
ps.setLong(1, fromUserId);
ps.setLong(2, toUserId);
ps.setBigDecimal(3, amount);
ps.setString(4, status);
ps.setString(5,note);

ps.executeUpdate();

		}catch(Exception e) {
			logger.error("Error saving SEND transaction",e);
			
		}
	}
	
	public List<Transaction>getUserTransactions(long userId){
		
		String sql = "SELECT * FROM transactions " +
		        "WHERE from_user_id = ? OR to_user_id = ? " +
		        "ORDER BY created_at DESC" ;
		
		List<Transaction>list = new ArrayList<>();
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql))
		{
		ps.setLong(1, userId);
		ps.setLong(2, userId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Transaction tx = new Transaction();
			
			tx.setTransactionId(rs.getLong("transaction_id"));
            tx.setFromUserId((Long) rs.getObject("from_user_id"));
            tx.setToUserId((Long) rs.getObject("to_user_id"));
            tx.setAmount(rs.getBigDecimal("amount"));
            tx.setTransactionType(rs.getString("transaction_type"));
            tx.setStatus(rs.getString("status"));
            tx.setNote(rs.getString("note"));
            tx.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            list.add(tx);
		}
		
		
			
		}catch(Exception e) {
			logger.error("Error fetching transaction history for userId= {}",userId,e);
			
		}
		
		return list;
		
		
	}
	
	
	
	
	
	
	
}
