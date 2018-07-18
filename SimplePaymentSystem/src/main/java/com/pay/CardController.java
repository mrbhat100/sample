package com.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.authorize.api.contract.v1.CreateCustomerPaymentProfileResponse;
import net.authorize.api.contract.v1.CreateTransactionResponse;

@RestController
@RequestMapping("ePay")
public class CardController{

	@Value("${api_login_id}")
	String apiLoginId;
	
	@Value("${transaction_key}")
	String transactionKey;
	
	
	@Autowired
	CardService cardService;
	
	@Autowired
	CreateCustomerPaymentProfileService createCustomerPaymentProfileService; 
	
	@RequestMapping("test")
	public String testDrive() {
		return cardService.TestConnect();
	}
	
	@RequestMapping("pay")
	public CreateTransactionResponse paymentData() {
		CreateTransactionResponse response = cardService.payDirectt();
	        return response;
	}
	@RequestMapping("createProfile")
	public CreateCustomerPaymentProfileResponse createCustomerPaymentProfile() {
		return createCustomerPaymentProfileService.createCardProfile(apiLoginId, transactionKey, "12345");
	}
}
