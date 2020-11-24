package com.example.helloworld.util;

public class Validator {

    public static boolean isTrue(String param){

        return param.matches("/^[0-9]+$/");
    }

    public static boolean isThreeLetters(String param){
        return param.matches("[a-zA-Z]{3}");
    }

    public static boolean isLetters(String param){
        return param.matches("/[a-zA-Z]+$/");
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
