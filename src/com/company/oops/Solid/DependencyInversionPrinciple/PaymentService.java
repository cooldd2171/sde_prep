package com.company.oops.Solid.DependencyInversionPrinciple;

public class PaymentService {
    Card card;
    
    void pay(int amount,String input){
        if(input.equals("debit")){
            card=new CreditCard();
        }
        else card=new DebitCard();
        
        card.makePayment(amount);
    }
}
