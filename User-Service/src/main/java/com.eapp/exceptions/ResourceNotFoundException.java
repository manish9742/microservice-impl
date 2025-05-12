package com.eapp.exceptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(){
        super("Resouce Not found");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
