package com.mdss.client.controllers.exceptions;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    private List<String> errors;

    public ApiErrors(){

    }

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String message){
        this.errors = Arrays.asList(message);
    }

    public List<String> getErrors() {
        return errors;
    }
}
