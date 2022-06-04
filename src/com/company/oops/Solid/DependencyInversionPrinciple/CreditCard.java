package com.company.oops.Solid.DependencyInversionPrinciple;

public class CreditCard implements Card{
    @Override
    public boolean makePayment(int amount) {
        return false;
    }
}
