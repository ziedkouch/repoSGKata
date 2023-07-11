package com.sg.kata.bean;

import java.time.LocalDateTime;

public class Operation {

	TypeEnum type ;
	LocalDateTime date ;
	double amount ;
	double balance ;
	
	String foreignKeyAccount ;
	
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum credit) {
		this.type = credit;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getForeignKeyAccount() {
		return foreignKeyAccount;
	}
	public void setForeignKeyAccount(String foreignKeyAccount) {
		this.foreignKeyAccount = foreignKeyAccount;
	}
	
	
}
