package com.company.oops.Solid.SingleResponsibilityPrinciple;

public class NotificationService {
    
    public void sendOtp(int mobileNumber,String channel){
        switch (channel){
            case "sms":
                System.out.println("Sending sms to contact: "+mobileNumber);
            case "email":
                System.out.println("Sending email to contact: "+mobileNumber);
        }
    }
}
