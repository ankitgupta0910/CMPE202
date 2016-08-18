package com.uber.payments;

public class DebitCardPaymentStrategy implements PaymentStrategy{
	public void pay(int amount)
	  {
	    System.out.println("Customer will pay " +amount+ "dollars with Debit Card");
	  }

}
