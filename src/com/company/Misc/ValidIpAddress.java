package com.company.Misc;

public class ValidIpAddress {
    public static void main(String[] args) {
        //isValid("222.111.111.111");
        isValid("0.0.0.0.");
    }

    public static boolean isValid(String s) {
        
        String[] components=s.split("\\.");
        if(components.length!=4){
            return false;
        }
        for(String each: components){
            if(each.length()>3){
                return false;
            }
            if(each.equals("") ||(each.charAt(0)=='0'&& each.length()>1)){
                return false;
            }
            int number=Integer.parseInt(each);
            if(number>255){
                return false;
            }
        }
        
        return true;
    }
}
