package com.sg.kata.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sg.kata.services.ClientService;



@RestController
@RequestMapping(value="/SG/ClientAccount/")
@CrossOrigin(origins = "*")
public class RestApi {
	
	
	//on supposera que nous avons déja verifier l'existance du client et son compte aussi 
	//La classe Client sert simplement pour montrer la structure du model qui doit être mis en place
	
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping(path="/Save") 
	 public @ResponseBody String saveMoney (@RequestParam String referenceAccount
		      , @RequestParam double amount ) {
		
			return clientService.saveMoney(referenceAccount,amount) ;
		}
	
	@PostMapping(path="/Retrieve") 
	 public @ResponseBody String retrieveMoney (@RequestParam String referenceAccount
		      , @RequestParam double amount) {
		
		return clientService.retrieveMoney(referenceAccount,amount) ;
		}
	
	@PostMapping(path="/Check") 
	 public @ResponseBody String checkOperations (@RequestParam String referenceAccount) {
		
		return clientService.checkOperations(referenceAccount) ;
		}
}
