package com.company.oops.pattern.Solid.OpenClosedPrinciple;

public interface NotificationService {
    
    public void sendOtp(String mobileNumber);
    public void sendMessage(String message,String mobileNumber);


}
