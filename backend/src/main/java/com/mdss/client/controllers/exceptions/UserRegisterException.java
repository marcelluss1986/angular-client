package com.mdss.client.controllers.exceptions;

public class UserRegisterException extends RuntimeException{

    public UserRegisterException(String login){
        super("User already register for this login " + login);
    }
}
