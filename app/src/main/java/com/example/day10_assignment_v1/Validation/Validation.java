package com.example.day10_assignment_v1.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidAlpha(String alpha){
        return alpha.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    }
    public static boolean isValidEmail(String email){

        return email.matches("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$");
    }
    public static boolean isValidPhoneNum(String phone){
        return phone.matches("^(?:\\([2-9]\\d{2}\\)\\ ?|[2-9]\\d{2}(?:\\-?|\\ ?))[2-9]\\d{2}[- ]?\\d{4}$");
    }
    public static boolean isValidAddress(String address){
        return address.matches("^[a-zA-Z0-9\\s.,'-]*$");
    }

    public static boolean isValidPostal(String postal){
        return postal.matches("[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ] ?[0-9][ABCEGHJKLMNPRSTVWXYZ][0-9]");
    }





    public static boolean isValidAlphaOrNull(String alpha){
        return alpha.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    }
    public static boolean isValidEmailOrNull(String email){

        return email.matches("^$|^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$");
    }
    public static boolean isValidPhoneNumOrNull(String phone){
        return phone.matches("^(?:\\([2-9]\\d{2}\\)\\ ?|[2-9]\\d{2}(?:\\-?|\\ ?))[2-9]\\d{2}[- ]?\\d{4}$");
    }
    public static boolean isValidAddressOrNull(String address){
        return address.matches("^[a-zA-Z0-9\\s.,'-]*$");
    }

    public static boolean isValidPostalOrNull(String postal){
        return postal.matches("^[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ] ?[0-9][ABCEGHJKLMNPRSTVWXYZ][0-9]");
    }
    public static boolean isValidUrlOrNull(String url){
        return url.matches("^(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})");
    }
}
