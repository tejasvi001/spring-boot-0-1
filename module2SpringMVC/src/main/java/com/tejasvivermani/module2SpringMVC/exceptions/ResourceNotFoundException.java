package com.tejasvivermani.module2SpringMVC.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String message){
        super("Resource Not found for the - "+ message);
    }
}
