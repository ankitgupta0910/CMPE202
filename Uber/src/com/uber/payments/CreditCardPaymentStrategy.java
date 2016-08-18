package com.uber.payments;

public class CreditCardPaymentStrategy implements PaymentStrategy{
	 public void pay( int amount )
	  {
	    System.out.println("Customer will pay " + amount + "dollars with Credit Card");
	  }

}
