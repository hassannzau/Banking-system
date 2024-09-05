package com.banking.system.banking.system.service;

import java.util.List;


import com.banking.system.banking.system.entity.UserAccount;

public interface AccountService {
	
	//we are creating the methods that we will be implementing
	public UserAccount createAccount(UserAccount account);
	public UserAccount getAccountDetailsByAccountNumber(Long accountNumber);
	public List<UserAccount> getAllAccountDetails();
	//Depositing some money
	public UserAccount depositAmount(Long accountNumber, Double amount);
	//withdrawing some money
	public UserAccount withdrawAmount(Long accountNumber, Double amount);
	//closing the account
	public void closeAccount(Long accountNumber);

}
