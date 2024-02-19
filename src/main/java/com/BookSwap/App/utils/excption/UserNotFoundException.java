package com.BookSwap.App.utils.excption;

public class UserNotFoundException extends RuntimeException{

    public  UserNotFoundException(String str){
        super(str);
    }
}
