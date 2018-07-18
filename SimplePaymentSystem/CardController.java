package com.pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.authorize.api.contract.v1.TransactionResponse;

@RestController
@RequestMapping("ePay")
public class CardController{

	@Autowired
	CardService cardService;
	
	@RequestMapping("test")
	public String testDrive() {
		return cardService.TestConnect();
	}
	
	@RequestMapping("pay")
	public String paymentData() {
		/* PaymentType paymentType = new PaymentType();
	        CreditCardType creditCard = new CreditCardType();
	        creditCard.setCardNumber("1234123412341234");
	        creditCard.setExpirationDate("0822");
	        paymentType.setCreditCard(creditCard);
	        
	        
	        TransactionRequestType txnRequest = new TransactionRequestType();
	        txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
	        txnRequest.setPayment(paymentType);
	        txnRequest.setAmount(new BigDecimal(500.00));
	        
	        cardService.Initialize();*/
	        
	        TransactionResponse response = cardService.payDirectt();
	        
	        
	        return response.getResponseCode();
	}
}
