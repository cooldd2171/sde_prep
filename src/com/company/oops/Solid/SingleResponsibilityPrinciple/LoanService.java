package com.company.oops.Solid.SingleResponsibilityPrinciple;

public class LoanService {

    public int getInterest(String type) {

        switch (type) {
            case "home loan":
                return 8;
            case "car loan":
                return 10;
            default:
                return 11;
        }
    }
}
