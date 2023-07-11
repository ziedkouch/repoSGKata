package com.sg.kata.services;


import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sg.kata.bean.Account;
import com.sg.kata.bean.Client;
import com.sg.kata.bean.Operation;
import com.sg.kata.bean.TypeEnum;


@Service
public class ClientService {
	
	Client client;
	Account account;
	List<Operation> operations = new ArrayList<Operation>();
	
	public ClientService()
	{
		this.initData();
	}
	
	void initData()
	{
		client  = new Client ();
		client.setReferenceClient("ziedKOUCH");
		client.setNom("KOUCH");
		client.setPrenom("zied");
		
		account = new Account();
		account.setReferenceAccount("accountZiedKOUCH");
		account.setAmount(1623);
		account.setForeignKeyClient("ziedKOUCH");
		
		Operation operation1 = new Operation();
		operation1.setType(TypeEnum.CREDIT);
		operation1.setAmount(12);
		operation1.setBalance(1640);
		operation1.setForeignKeyAccount("accountZiedKOUCH");
		operation1.setDate(LocalDateTime.now());
		
		Operation operation2 = new Operation();
		operation2.setType(TypeEnum.DEBIT);
		operation2.setAmount(40);
		operation2.setBalance(1600);
		operation2.setForeignKeyAccount("accountZiedKOUCH");
		operation2.setDate(LocalDateTime.now());
		
		Operation operation3 = new Operation();
		operation3.setType(TypeEnum.CREDIT);
		operation3.setAmount(50);
		operation3.setBalance(1650);
		operation3.setForeignKeyAccount("accountZiedKOUCH");
		operation3.setDate(LocalDateTime.now());
		
		operations.add(operation1);
		operations.add(operation2);
		operations.add(operation3);
	}
	
	private String verifAccount(String referenceAccount)
	{
		return referenceAccount.equals(account.getReferenceAccount())?"":"Account doesn't exist " ;
	}
	
	public String saveMoney( String referenceAccount,  double amount)
	{
		String result = this.verifAccount(referenceAccount); 
		//compte trouvé
		if( result.isBlank() )
		{
			account.setAmount(account.getAmount() + amount);
			
			Operation operation = new Operation();
			operation.setType(TypeEnum.CREDIT);
			operation.setAmount(amount);
			operation.setBalance( operations.get(operations.size() - 1).getBalance() + amount);
			operation.setForeignKeyAccount(referenceAccount);
			operation.setDate(LocalDateTime.now());
			
			operations.add(operation);
			
			result = " current bank balance  : " + account.getAmount() ;
		}	
		
			return result ;
			
	}
	
	public String retrieveMoney( String referenceAccount,  double amount)
	{
		String result = this.verifAccount(referenceAccount); 
		//compte trouvé
		if( result.isBlank() )
		{
			//on va supposé qu'on ne fait pas de controle sur le solde disponible   
			account.setAmount(account.getAmount() - amount);
			
			Operation operation = new Operation();
			operation.setType(TypeEnum.DEBIT);
			operation.setAmount(amount);
			operation.setBalance( operations.get(operations.size() - 1).getBalance() - amount);
			operation.setForeignKeyAccount(referenceAccount);
			operation.setDate(LocalDateTime.now());
			
			operations.add(operation);
			
			result = " current bank balance  : " + account.getAmount() ;
		}	
		
			return result ;
		
	}
	
	public String checkOperations (String referenceAccount)
	{
		String result = this.verifAccount(referenceAccount); 
		//compte trouvé
		if( result.isBlank() )
		{
			result += "Operations :\n";
			//affiché uniquement les opérations du compte demandé
			for (Operation operation : operations.stream()
							.filter(operation -> operation.getForeignKeyAccount().equals(referenceAccount))
							.collect(Collectors.toList())
				)			
			{ 
				result = result.concat("type : ").concat(operation.getType().toString())
					.concat(" , ")
					.concat("Date : ").concat(operation.getDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT)))
					.concat(" , ")
					.concat("amount : ").concat(Double.toString(operation.getAmount()))
					.concat(" , ")
					.concat("balance : ").concat(Double.toString(operation.getBalance()))
					.concat("\n");
			};
		}
		
		return result ;
	}
	
	
}


