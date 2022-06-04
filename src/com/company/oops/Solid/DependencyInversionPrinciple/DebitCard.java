package com.company.oops.Solid.DependencyInversionPrinciple;

public class DebitCard implements Card{
    @Override
    public boolean makePayment(int amount) {
        return false;
    }
}
