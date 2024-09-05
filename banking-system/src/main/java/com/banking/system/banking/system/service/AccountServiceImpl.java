package com.banking.system.banking.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.system.banking.system.entity.UserAccount;
import com.banking.system.banking.system.repository.UserRepository;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	UserRepository repository;

	@Override
	public UserAccount createAccount(UserAccount account) {
		// TODO Auto-generated method stub
		UserAccount account_saved=repository.save(account);
		return account_saved;
	}

	@Override
	public UserAccount getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<UserAccount> userAccount=repository.findById(accountNumber);
	    if(userAccount.isEmpty()) {
	    	throw new RuntimeException("Account not found ");
	    }
	    
	   UserAccount accountDetailsFound =userAccount.get();
		return accountDetailsFound;
		}

	@Override
	public List<UserAccount> getAllAccountDetails() {
		List<UserAccount> listOfAccounts=repository.findAll();
		return listOfAccounts;
	}

	@Override
	public UserAccount depositAmount(Long accountNumber, Double amount) {
		//first check if the account is present
		Optional<UserAccount> userAccount=repository.findById(accountNumber);
		if(userAccount.isEmpty()) {
			throw new RuntimeException("User Account doesn't exist");
		}
		
		UserAccount accountPresent=userAccount.get();
		Double totalBalance=accountPresent.getBalance() + amount;
		accountPresent.setBalance(totalBalance);
		repository.save(accountPresent);
		return accountPresent;
	}

	@Override
	public UserAccount withdrawAmount(Long accountNumber, Double amount) {
		Optional<UserAccount> userAccount=repository.findById(accountNumber);
		if(userAccount.isEmpty()) {
			throw new RuntimeException("User Account doesn't exist");
		}
		UserAccount accountPresent=userAccount.get();
		Double accountBalance=accountPresent.getBalance()- amount;
		accountPresent.setBalance(accountBalance);
		repository.save(accountPresent);
		return accountPresent;
	    
	}

	@Override
	public void closeAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		
	}

}
