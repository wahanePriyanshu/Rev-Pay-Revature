package com.revpay.controller;

import java.math.BigDecimal;
import java.util.Scanner;

import com.revpay.model.User;
import com.revpay.service.UserService;
import com.revpay.service.UserServiceImpl;
import com.revpay.service.WalletService;
import com.revpay.service.WalletServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthController {

	private final UserService userService = new UserServiceImpl();
    private final Scanner scanner = new Scanner(System.in);
    private final WalletService walletService = new WalletServiceImpl();
    private static final Logger logger = LogManager.getLogger(AuthController.class);

    public void start() {
        while (true) {
            System.out.println("\n=== Welcom to RevPay  ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
            case 1:
            	register();
            	break;
            case 2:
            	login();
            	break;
            case 3:
            	System.out.println("Thank you for using RevPay");
            	return;
            default :
            	System.out.println("Invalid choice");
            }
        }
    }

    private void register() {
        System.out.println("\n--- User Registration ---");

        System.out.print("Account Type (PERSONAL/BUSINESS): ");
        String accountType = scanner.nextLine().toUpperCase();

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Transaction PIN: ");
        String pin = scanner.nextLine();

        System.out.print("Security Question: ");
        String question = scanner.nextLine();

        System.out.print("Security Answer: ");
        String answer = scanner.nextLine();

       User user = new User(
    		   0, accountType,
    		   fullName,
    		   email,
    		   phone,
    		   password,
    		   pin,
    		   question,
    		   answer, 0, false, false, null, null
    		   );
        boolean success = userService.registerUser(user);

        if (success) {
            System.out.println("✅ Registration successful!");
        } else {
            System.out.println("❌ Registration failed!");
        }
    }

    private void login() {
        System.out.println("\n--- User Login ---");

        System.out.print("Email or Phone: ");
        String input = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userService.login(input, password);

        if (user != null) {
            logger.info("User logged in successfully : {}",user.getEmail());
            System.out.println(" Welcome, " + user.getFullName());
            
//            System.out.println("Your Wallet Balance : 💸 " 
//            		+ walletService.viewBalance(user.getUserId()));
            userMenu(user);
        } else {
            logger.info("Invalid login attempt for input :",input);
        }
    }
        
        private void userMenu(User user) {
        	System.out.println("--Wallet Menue--");
        	System.out.println("1.view Balance");
        	System.out.println("2.Add Money");
        	System.out.println("3.Logout");
        	System.out.println("Choose option :");
        	
        	int choice = scanner.nextInt();
        	scanner.nextLine();
        	
        	switch(choice) {
        	case 1:
        		System.out.println("Wallet Balance :"+
        		walletService.viewBalance(user.getUserId()));
        		break;
        	case 2:
        		addMoney(user);
        		break;
        	case 3:
        		System.out.println("Logged out Successfully ");
        		return;
        	default :
        		System.out.println("Invalid choice");
        		
        	}
        }
        
        
    

	private void addMoney(User user) {
		
		System.out.println("Enter amount to add in wallet :");
		BigDecimal amount = new BigDecimal(scanner.nextLine());
		
		boolean success = walletService.addMoney(user.getUserId(), amount);
		
		if(success) {
			logger.info("Money add for userId : {} , amount : {}",user.getUserId(),amount);
			System.out.println("Updated balance :"
			+ walletService.viewBalance(user.getUserId()));
		}else {
			System.out.println("Failed to add money");
		}
	}
	}
	
