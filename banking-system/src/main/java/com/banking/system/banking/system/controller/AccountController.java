package com.banking.system.banking.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.system.banking.system.entity.UserAccount;
import com.banking.system.banking.system.service.AccountService;

@RestController
@RequestMapping("/account")

public class AccountController {
	
	@Autowired
	AccountService service;

	//creating an account
		@PostMapping("/createAccount")
	public UserAccount createAccount(@RequestBody UserAccount account) {
			
			UserAccount createAccount=service.createAccount(account);
		return createAccount;
		}
		
		//Getting a single bank account
		@GetMapping("/{accountNumber}")
		public UserAccount getAccountDetailsByAccountNumber(@PathVariable Long accountNumber) {
			
			UserAccount account=service.getAccountDetailsByAccountNumber(accountNumber);
			return account;
		
}
		//Getting All Accounts
		@GetMapping("/getAllAccounts")
		public List<UserAccount> getAllAccountDetails(){
			List<UserAccount> allAccountDetails =service.getAllAccountDetails();
			return allAccountDetails;
		}
		
		//Depositing money
		@PutMapping("/deposit/{accountNumber}/{amount}")
		public UserAccount depositAmount(@PathVariable Long accountNumber,@PathVariable  Double amount) {
			UserAccount account=service.depositAmount(accountNumber, amount);
			
			return account;
		}
		
		//Withdrawing money
		@PutMapping("/withdraw/{accountNumber}/{amount}")
		public UserAccount withdrawAmount(Long accountNumber, Double amount) {
			UserAccount account=service.withdrawAmount(accountNumber, amount);
			return account;
		}
	
}
