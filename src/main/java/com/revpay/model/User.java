package com.revpay.model;

import java.time.LocalDateTime;

public class User {

	private long userId;
	private String accountType;
	private String fullName;
	private String email;
	private String phone;
	private String passwordHash;
	private String transactionPin;
	private String securityQuestion;
	private String securityAnswer;
	private int failedAttempts;
	private boolean locked;
	private boolean active;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", accountType=" + accountType + ", fullName=" + fullName + ", email=" + email
				+ ", phone=" + phone + ", passwordHash=" + passwordHash + ", transactionPin=" + transactionPin
				+ ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer + ", failedAttempts="
				+ failedAttempts + ", locked=" + locked + ", active=" + active + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}


	public User() {}
	
	
	public User(long userId, String accountType, String fullName, String email, String phone, String passwordHash,
			String transactionPin, String securityQuestion, String securityAnswer, int failedAttempts, boolean locked,
			boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.userId = userId;
		this.accountType = accountType;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.passwordHash = passwordHash;
		this.transactionPin = transactionPin;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.failedAttempts = failedAttempts;
		this.locked = false;
		this.active = true;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getTransactionPin() {
		return transactionPin;
	}
	public void setTransactionPin(String transactionPin) {
		this.transactionPin = transactionPin;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public int getFailedAttempts() {
		return failedAttempts;
	}
	public void setFailedAttempts(int failedAttempts) {
		this.failedAttempts = failedAttempts;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	
}
