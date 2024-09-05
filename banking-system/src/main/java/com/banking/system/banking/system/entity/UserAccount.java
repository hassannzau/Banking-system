package com.banking.system.banking.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table
public class UserAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long account_number;
	
	private String account_holder_name;
	private Double balance;
	
	public UserAccount(  ) {

	}
	
	
	public UserAccount(String account_holder_name, Double balance) {
		super();
		this.account_holder_name = account_holder_name;
		this.balance = balance;
	}
	public Long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "UserAccount [account_number=" + account_number + ", account_holder_name=" + account_holder_name
				+ ", balance=" + balance + "]";
	}
	
	
	

}
