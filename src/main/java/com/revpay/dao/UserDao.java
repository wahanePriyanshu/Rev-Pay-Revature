package com.revpay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revpay.model.User;
import com.revpay.util.DBUtil;

public class UserDao {

	public long saveUser(User user) {
		String sql =  "Insert into users (account_type,full_name,email,"
				+ "phone,password_hash,transaction_pin"
				+ ",security_question,security_answer)"
				+ "values(?,?,?,?,?,?,?,?)";
		
		
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps =
					    con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS))
		
		{
			ps.setString(1,user.getAccountType());
			ps.setString(2,user.getFullName());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getPhone());
			ps.setString(5,user.getPasswordHash());
			ps.setString(6,user.getTransactionPin());
			ps.setString(7,user.getSecurityQuestion());
			ps.setString(8,user.getSecurityAnswer());
			
			int affected = ps.executeUpdate();

	        if (affected == 1) {
	            ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                return rs.getLong(1); // user_id
	            }
	        }

	    }
		
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return -1;
		
	}
	
	public User findByEmailOrPhone(String input) {
        String sql = "SELECT * FROM users  WHERE email = ? OR phone = ? ";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, input);
            ps.setString(2, input);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getLong("user_id"));
                user.setAccountType(rs.getString("account_type"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setTransactionPin(rs.getString("transaction_pin"));
                user.setSecurityQuestion(rs.getString("security_question"));
                user.setSecurityAnswer(rs.getString("security_answer"));
                user.setFailedAttempts(rs.getInt("failed_attempts"));
                user.setLocked(rs.getBoolean("is_locked"));
                user.setActive(rs.getBoolean("is_active"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
        
        
	}
	
	
	
	
	
}
