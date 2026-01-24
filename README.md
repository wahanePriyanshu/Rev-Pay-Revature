# RevPay – Console-Based Digital Payment System

## 📌 Project Overview

RevPay is a secure, console-based digital payment and money management application developed using Java and MySQL.  
It supports both **personal** and **business** users, enabling safe transactions, wallet management, invoice handling, and loan processing.

The project is built with a **modular architecture**, focusing on **security, transaction integrity, and scalability**, and can be extended into a web or mobile application in the future.

---

## 👤 Personal Account Features

- User registration with full name, email, phone number, password, and security questions
- Secure login using email/phone and password
- Send money to other users using:
  - Username
  - Email
  - Phone number
  - Account ID
- Request money and manage requests (accept / decline / cancel)
- Add and manage payment methods (credit/debit cards)
- Set default payment method
- Wallet management (add money / withdraw – simulated)
- View transaction history with filters:
  - Date range
  - Transaction type
  - Amount
  - Status
- In-app notifications for transactions, money requests, and alerts

---

## 🏢 Business Account Features  
*(Includes all personal account features)*

- Business account registration with:
  - Business name
  - Business type
  - Tax ID
  - Address
  - Verification documents
- Add business payment methods (cards and bank accounts)
- Accept customer payments via payment requests and invoices
- Create and manage invoices with:
  - Itemized details
  - Customer information
  - Payment terms
  - Paid / unpaid status tracking
- Apply for business loans and track loan status
- Manage loan repayments
- View business analytics:
  - Revenue reports
  - Transaction summaries
  - Outstanding invoices
  - Payment trends
  - Top customers
- Send invoice notifications to customers (in-app)

---

## 🔐 Authentication & Security

- Password hashing using BCrypt
- Transaction PIN (separate from login password)
- Password change with PIN verification
- Forgot password recovery using security questions
- Account lockout after multiple failed login attempts
- Session timeout handling
- Simulated two-factor authentication (security codes)
- Card data encryption using AES-256

---

## 🔔 Notification System

- In-app notification system
- Notifications categorized by:
  - Transactions
  - Requests
  - Alerts
- Read / unread status tracking
- Notification preference management

---

## 🛠️ Technologies Used

- Java
- MySQL
- JDBC
- JUnit
- Log4J
- Git & GitHub

---

## 🗂️ Project Structure

RevPay
├── src/main/java
│ └── com.revpay
│ ├── controller
│ ├── service
│ ├── dao
│ ├── model
│ ├── util
│ └── RevPayApplication.java
├── src/test/java
│ └── com.revpay
├── resources
│ └── database.sql
├── pom.xml
└── README.md

## 🚀 How to Run the Project

1. Clone the repository
   ```bash
   git clone https://github.com/wahanePriyanshu/Rev-Pay-Revature.git
Import the project into IntelliJ IDEA or Eclipse

2.Configure MySQL database and update JDBC credentials

3.Run the SQL script from:

4.resources/database.sql
Run:

RevPayApplication.java


# Project Status

- User Registration & Login ✔️

- Wallet Creation ✔️

- Secure Authentication ✔️

- Core transaction flow implemented

- Console-based working application

# Author
Priyanshu Wahane
